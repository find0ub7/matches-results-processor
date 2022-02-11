package com.letscode.santander811.championship.utils;

import com.letscode.santander811.championship.exceptions.FileGenerationException;
import com.letscode.santander811.championship.exceptions.FileSystemReaderException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;

public class FileSystemUtils {

    public static List<String> readLines(String filePath) {
        try {
            File file = FileUtils.getFile(FileSystemUtils.class.getClassLoader().getResource(filePath).getFile());
            return FileUtils.readLines(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileSystemReaderException(e);
        }
    }

    public static void write(String filePath, Collection<String> lines) {
        try {
            FileUtils.writeLines(new File(filePath), lines);
            System.out.println("Created file: " + filePath);
        } catch (IOException e) {
            System.out.println("Fail to export file " + filePath);
            e.printStackTrace();
            throw new FileGenerationException(e);
        }
    }
}
