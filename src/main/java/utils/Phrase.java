package utils;

import java.util.Properties;

public class Phrase {
    protected final String rightSearchValue;

    protected final String wrongSearchValue;

    public Phrase(Properties properties) {
        rightSearchValue = properties.getProperty("phrase.rightSearchValue");
        wrongSearchValue = properties.getProperty("phrase.wrongSearchValue");
    }

    public String getRightSearchValue() {
        return rightSearchValue;
    }

    public String getWrongSearchValue() {
        return wrongSearchValue;
    }
}
