package amazon.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    
    Properties properties;
    String path = "C:\\Users\\Fudugo\\eclipse-workspace\\Amazon.com\\Configuration\\config.properties";
    
    //Constructor
    public ReadConfig() {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(path);
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getBaseUrl() {
        String value = properties.getProperty("baseurl");
        if (value != null)
            return value;
        else
            throw new RuntimeException("Base URL is not specified in the config file");
    }
    
    public String getBrowser() {
        String value = properties.getProperty("browser");
        if (value != null)
            return value;
        else
            throw new RuntimeException("Browser is not specified in the config file");
    }
}
