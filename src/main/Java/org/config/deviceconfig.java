package org.config;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.utils.FileUtility;
import java.io.IOException;
import java.nio.file.Files;

public class deviceconfig {

    public static AndroidDeviceModel readAndroidDeviceConfig() throws IOException {
        byte[] jsonData = null;
        ObjectMapper objectMapper = new ObjectMapper();
        jsonData = Files.readAllBytes(FileUtils.getFile(FileUtility.getFile("androidDevice.json")).toPath());
        AndroidDeviceModel[] androidDeviceModels = objectMapper.readValue(jsonData, AndroidDeviceModel[].class);
        System.out.println(androidDeviceModels);
        return new AndroidDeviceModel(androidDeviceModels);
    }


}
