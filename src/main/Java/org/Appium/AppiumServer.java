package org.Appium;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.log4j.Logger;

import java.io.File;

public class AppiumServer {
    public static AppiumDriverLocalService appium;
    Logger log = Logger.getLogger("testinfolog");

    public static void start(){
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withIPAddress("127.0.0.1")
                .usingPort(4723);
        appium = builder.build();
        System.out.println("Starting the Appium Server on 127.0.0.1:4723");
        appium.start();
    }

    public static void stop(){
        appium.stop();
    }

}
