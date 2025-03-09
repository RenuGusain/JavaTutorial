package com.renu.java.nio.file;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

public class FileOperations {
    static Path rootDir = Paths.get("data");

    public static void main(String[] args) throws Exception {
        BigDecimal bigDecimal=new BigDecimal(new Double(95.89));
        System.out.println(bigDecimal);
        //
        // writeFileWithReaplace();
       // readFileWordBYWord();


    }

    public static void copyingFile() throws Exception {

        Path srcFile = Paths.get(rootDir.resolve("src.text").toString());
        Path destFile = Paths.get(rootDir.resolve("dest.text").toString());
        if (Files.notExists(srcFile)) {
            Files.createFile(srcFile);
        }
        if (Files.notExists(destFile)) {
            Files.createFile(destFile);
        }


        Files.copy(srcFile, destFile, StandardCopyOption.REPLACE_EXISTING);


    }

    public static void readFile() throws IOException {


    }

    public static void writeFileWithReaplace() throws IOException {
        Path srcFile = Paths.get(rootDir.resolve("src.text").toString());

        List<String> lines = Arrays.asList("Hello World", "I am a filesystem");
        Files.write(srcFile, lines, StandardCharsets.UTF_8);
    }

    public static void writeFileWithAppendMode() throws IOException {
        Path srcFile = Paths.get(rootDir.resolve("src.text").toString());

        List<String> lines = Arrays.asList("Hello World", "I am a filesystem");
        Files.write(srcFile, lines, StandardOpenOption.APPEND);
    }

    public static void readFileWordBYWord() {
        Path srcFile = Paths.get(rootDir.resolve("src.text").toString());
        try (FileChannel channel = FileChannel.open(srcFile, StandardOpenOption.READ)) {

            ByteBuffer buffer = ByteBuffer.allocate(8192);
            StringBuilder word = new StringBuilder();
            while (channel.read(buffer) > 0) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    char c = (char) buffer.get();
                    if (Character.isWhitespace(c)) {
                        if (word.length() > 0) {
                            System.out.println(word.toString());
                            word.setLength(0);
                        }
                    } else {
                        word.append(c);
                    }
                }
                buffer.clear();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
