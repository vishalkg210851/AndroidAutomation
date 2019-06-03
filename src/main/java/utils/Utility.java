package utils;

import java.util.Properties;
import java.io.*;
import org.apache.log4j.Logger;

public class Utility {

    static Logger log = Logger.getLogger(Utility.class);

    /**
     * Read the properties files
     */

    public Properties getPropertiesValue() {
        Properties properties = null;
        String path = System.getProperty("user.dir") + "/config.properties";
        try {
            File file = new File(path);
            FileInputStream fileInput = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInput);
            fileInput.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }


}









