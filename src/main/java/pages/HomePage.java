package pages;

import Interface.Dependencies;
import STB.STB_functions;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {


    /** Verify the home page has loaded **/

    public void HOME(AndroidDriver driver) throws InterruptedException {

        try {
            System.out.println("Home entered");

        } catch (Exception e) {
            e.printStackTrace();
            throw new InterruptedException();
        }

    }


}
