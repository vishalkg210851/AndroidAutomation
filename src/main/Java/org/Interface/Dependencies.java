package org.Interface;
import org.utils.Utility;
import java.util.Properties;

public interface Dependencies {

    String root_path = System.getProperty("user.dir");
    String config_path = root_path+"/Config.properties";
    Utility readWriteFile = new Utility();
    Properties properties = readWriteFile.getPropertiesValue();
    String Left_Key = properties.getProperty("KEYCODE_DPAD_LEFT");
    String Back= properties.getProperty("KEYCODE_BACK");
    String Up_Key = properties.getProperty("KEYCODE_DPAD_UP");
    String DOWN_key = properties.getProperty("KEYCODE_DPAD_DOWN");
    String Right_Key= properties.getProperty("KEYCODE_DPAD_RIGHT");
    String OK = properties.getProperty("KEYCODE_DPAD_OK");
}
