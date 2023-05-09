package io.work_with_files;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

/**
 * {@link AbstractionFileDemo} demonstrates API of {@link java.io.File} abstraction
 */
public class AbstractionFileDemo {
    private static final String PATH_NAME = "src/main/java/io/basics";

    public static void main(String[] args) {

        File file = new File(PATH_NAME); // a directory or a file can be submitted

        System.out.println("exists: " + file.exists());
        System.out.println("isFile: " + file.isFile());
        System.out.println("isDirectory: " + file.isDirectory());
        System.out.println("isHidden: " + file.isHidden());
        System.out.println("isAbsolute: " + file.isAbsolute());
        System.out.println("name: " + file.getName());
        System.out.println("path: " + file.getPath());
        System.out.println("absolute path: " + file.getAbsolutePath());
        System.out.println("length: " + file.length());
        System.out.println("files names: " + Arrays.toString(file.list())); // all names of files inside the directory
        System.out.println("files names filtered: " + Arrays.toString(file.list((dir, name) -> name.startsWith("text"))));
        System.out.println("files relative paths: " + Arrays.toString(file.listFiles())); // all files inside the directory represented by their relative paths (src\main\java\io\basics\text-file.txt)
        System.out.println("lastModified: " + new Date(file.lastModified()));
        System.out.println("can execute: " + file.canExecute());
        System.out.println("can read: " + file.canRead());
        System.out.println("can write: " + file.canWrite());
        System.out.println("parent directory: " + file.getParent()); // relative path of the parent directory
    }
}
