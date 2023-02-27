package Utils;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.util.Properties;

public abstract class FileReader {
    Properties properties;

    protected FileReader(String fileLocation) {
        loadFile(fileLocation);
        loadData();
    }

    @SneakyThrows
    public void loadFile(String fileLocation) {
        properties = new Properties();
        properties.load(new FileInputStream(fileLocation));
    }

    abstract void loadData();
}
