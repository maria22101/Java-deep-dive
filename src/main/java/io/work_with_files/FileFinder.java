package io.work_with_files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link FileFinder} class demonstrates finding files with the set extension
 * in the submitted directory's tree. The class uses {@link java.io.File}
 */
public class FileFinder {

    public static void main(String[] args) {
        List<File> foundFiles = new ArrayList<>();
        findFiles(new File("src/main/java/examples_code"), ".java", foundFiles);
        foundFiles.forEach(System.out::println);
    }

    public static void findFiles(File rootDir, String extension, List<File> foundFiles) {
        validateRootDirectory(rootDir);
        for (File file : rootDir.listFiles()) {
            if (file.isDirectory()) {
                findFiles(file, extension, foundFiles);
            } else {
                collectFileWithExtension(file, extension, foundFiles);
            }
        }
    }

    private static void validateRootDirectory(File rootDir) {
        if (!rootDir.isDirectory()) {
            throw new IllegalArgumentException(String.format("rootDir {%s} should be directory", rootDir));
        }
    }

    private static void collectFileWithExtension(File file, String extension, List<File> foundFiles) {
        if (file.isFile()) {
            if (file.getName().endsWith(extension)) {
                foundFiles.add(file);
            }
        }
    }
}
