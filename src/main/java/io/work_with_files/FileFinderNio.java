package io.work_with_files;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link FileFinderNio} demonstrates using {@link java.nio.file.Files} API in finding files
 * with the set extension in the submitted directory's tree.
 */
public class FileFinderNio {

    public static void main(String[] args) throws IOException {
        List<Path> foundFiles = new ArrayList<>();

        Files.walkFileTree(Paths.get("src/main/java/examples_code"), new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.getFileName().toString().endsWith(".java")) {
                    foundFiles.add(file);
                }
                return FileVisitResult.CONTINUE;
            }
        });

        foundFiles.forEach(System.out::println);
    }

}
