package utils;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Properties;

public abstract class FileReader {
    Properties properties;

    protected FileReader(String fileLocation) {
        loadFile(fileLocation);
    }

    @SneakyThrows
    public void loadFile(String fileLocation) {
        properties = new Properties();
        properties.load(new FileInputStream(fileLocation));
    }
}
