package io.work_with_files;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link AbstractionPathDemo} demonstrates API of {@link java.nio.file.Files} abstraction
 */

public class AbstractionPathDemo {
    private static final String PATH_NAME = "src/main/java/io/basics";
    private static final String SOURCE_FILE_NAME = "src/main/java/io/basics/text-file.txt";
    private static final String DESTINATION_FILE_NAME = "src/main/java/io/basics/text-file_nio-copy.txt";


    public static void main(String[] args) throws IOException {

        Path path = Paths.get(PATH_NAME); // a directory or a file can be submitted

        System.out.println("exists: " + Files.exists(path));
        System.out.println("isFile: " + Files.isRegularFile(path));
        System.out.println("isDirectory: " + Files.isDirectory(path));
        System.out.println("isHidden: " + Files.isHidden(path));
        System.out.println("isAbsolute: " + path.isAbsolute());
        System.out.println("name: " + path.getFileName());
        System.out.println("path: " + path);
        System.out.println("absolute path: " + path.toAbsolutePath());
        System.out.println("length: " + Files.size(path));

        List<String> innerFilesNames = new ArrayList<>();
        try {
            Files.newDirectoryStream(path).forEach(innerF -> innerFilesNames.add(innerF.getFileName().toString()));
            System.out.println("files names: " + innerFilesNames); // all names of files inside the directory
        } catch (NotDirectoryException e) {
            System.out.println("Files.newDirectoryStream can be applied only to a directory");
        }

        List<Path> innerFiles = new ArrayList<>();
        try {
            Files.newDirectoryStream(path).forEach(innerFiles::add);
            System.out.println("files relative paths: " + innerFiles); // all files inside the directory represented by their relative paths (src\main\java\io\basics\text-file.txt)
        } catch (NotDirectoryException e) {
            System.out.println("Files.newDirectoryStream can be applied only to a directory");
        }

        System.out.println("lastModified: " + Files.getLastModifiedTime(path));
        System.out.println("can execute: " + Files.isExecutable(path));
        System.out.println("can read: " + Files.isReadable(path));
        System.out.println("can write: " + Files.isWritable(path));
        System.out.println("get parent directory: " + path.getParent()); // relative path of the parent directory

        try {
            Files.copy(Paths.get(SOURCE_FILE_NAME), Paths.get(DESTINATION_FILE_NAME)); // copy a file; destination file will be created; FileAlreadyExistsException if destination file exists
        } catch (FileAlreadyExistsException e) {
            System.out.println("A copy: " + DESTINATION_FILE_NAME + " already exists");
        }

        List<String> strings = Files.readAllLines(Paths.get(DESTINATION_FILE_NAME)); // read lines from a file
        strings.forEach(System.out::println);

        List<String> overWritingStrings = List.of("One", "Two", "Three");
        Files.write(Paths.get(DESTINATION_FILE_NAME), overWritingStrings); // write the list into existing file overwriting its content

        Path p = Paths.get("src/main/java/io/basics/devstudy-net.html");
        boolean isDeleted = Files.deleteIfExists(p); // true if file exists, false otherwise; IOException in case of other IO errors
        System.out.println(isDeleted);

        Files.delete(p); // NoSuchFileException as the file does not exist any more
    }
}
