package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public abstract class FileReader {
    Properties properties;
    protected FileReader(String fileLocation) {
        loadFile(fileLocation);
        loadData();
    }

    public void loadFile(String fileLocation) {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(fileLocation));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    abstract void loadData();
}
