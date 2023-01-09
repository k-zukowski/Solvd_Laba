package utils.exceptions;

import java.io.File;

public class FileIsEmptyException extends Exception {
    public FileIsEmptyException(File file, String path) {
        super(String.format("File %s with path %s is empty", file,path));
    }
}
