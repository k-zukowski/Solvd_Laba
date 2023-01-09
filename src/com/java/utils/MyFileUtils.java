package utils;


import org.apache.commons.io.FileUtils;
import utils.exceptions.FileIsEmptyException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MyFileUtils {
    private String directory;
    private String name;
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void createFile(String directory, String name) {
        File dir = FileUtils.getFile(directory);
        FileUtils.getFile(dir, name);
        setDirectory(directory);
        setName(name);
        setFullName(directory + "\\" + name);
    }

    public String fileToString() {
        String data = "";
        File file = FileUtils.getFile(fullName);
        try {
            data = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
            if (data.isEmpty()) {
                throw new FileIsEmptyException(file, directory + name);
            }
        } catch (IOException | FileIsEmptyException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public void myWriteStringToFile(String content, boolean append) {
        File file = FileUtils.getFile(fullName);
        try {
            FileUtils.writeStringToFile(file, content, StandardCharsets.UTF_8, append);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void myWriteLinesToFile(ArrayList<String> content, boolean append) {
        File file = FileUtils.getFile(fullName);
        try {
            FileUtils.writeLines(file, StandardCharsets.UTF_8.name(), content, append);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
