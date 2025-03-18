package com.renu.java.tutorial.file;

import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PathTutorial {
    static List<String>lines= Arrays.asList("Hello World","I am renu");
    public static void main(String[] args) throws Exception{


copyOption();;
        Path relativePath = Paths.get("data/example.txt");
        Files.createDirectories(relativePath.getParent());
        Files.createFile(relativePath);





    }

    public static void  copyOption()throws Exception
    {
        Path directory=Paths.get("C:\\Users\\Renu\\Documents\\PERSONAL_PROECTS\\fileOperation");
        Files.createDirectories(directory);
        Path sourceFile=directory.resolve("source.text");
        Files.write(sourceFile,lines,StandardCharsets.UTF_8);
        Path target=directory.resolve("destination.text");
        Files.copy(sourceFile,target, StandardCopyOption.REPLACE_EXISTING);

    }
    public static void fileMethod() throws Exception
    {
        Path path= Paths.get("C:\\Users\\Renu\\Documents\\PERSONAL_PROECTS\\Readme.txt");

        //write into file
        Files.write(path,lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        System.out.println("File written succesfully");
        try(Stream<String>readLines=Files.lines(path))
        {
            readLines.forEach(System.out::println);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}



