package com.renu.java.tutorial.file;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindTheQueryFile {
    public static final Path SRC_DIR_PATH = Paths.get("C:\\Users\\Renu\\Documents\\Intershop\\apac-solutions\\icm_apac");


    public static void main(String[] args) throws Exception {
        String outputFile = "data/sqlfile.csv";

        List<String[]> fileList = new ArrayList<>();
        fileList.add(new String[]{"Index", "File Name", "Path", "No. of Lines", "FullPath"}); // CSV Header
        List<FileInfo> sqlPath = null;
        try (Stream<Path> paths = Files.walk(SRC_DIR_PATH)) {
            sqlPath = paths.filter(Files::isRegularFile)
                    .filter(path -> path.toString().endsWith(".query"))
                    .map(path -> new FileInfo(path.getFileName().toString(), SRC_DIR_PATH.relativize(path.toAbsolutePath()).toString(), countLine(path), path.toAbsolutePath().toString()))
                    .sorted(Comparator.comparingLong(FileInfo::getLineCount))
                    .collect(Collectors.toList());
            int index = 1;
            for (FileInfo file : sqlPath) {
                String fileName = file.fileName;
                String filePath = file.filePath;
                String relativePath = file.relativePath;
                String count = String.valueOf(file.lineCount);
                fileList.add(new String[]{String.valueOf(index), fileName, relativePath, count, filePath});
                index++;
            }
            writeCSVOutput(outputFile, fileList);

        } catch (Exception e) {
            System.out.println("Error occurred for file:" + sqlPath.toString());
            throw e;
        }


    }

    private static void writeCSVOutput(String outputFile, List<String[]> data) throws IOException {
        Path outputPath = Paths.get(outputFile);
        Files.createDirectories(outputPath.getParent());
        Files.deleteIfExists(outputPath);
        Files.createFile(outputPath);


        try (BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardCharsets.UTF_8)) {

            for (String row[] : data) {
                writer.write(String.join(",", row));
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("write scFile");
        }


    }

    private static long countLine(Path file) {
        try (Stream<String> lines = Files.lines(file, StandardCharsets.UTF_8)) {
            return lines.count();


        } catch (Exception e) {
            System.out.println("Error occurred while counting line for file:" + file.toString());

            throw new RuntimeException(e);
        }


    }


    static class FileInfo {
        String fileName;
        String filePath;
        long lineCount;
        String relativePath;

        public FileInfo(String fileName, String relativePath, long lineCount, String filePath) {
            this.fileName = fileName;
            this.filePath = filePath;
            this.lineCount = lineCount;
            this.relativePath = relativePath;
        }

        public long getLineCount() {
            return lineCount;
        }
    }
}
