package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;
    private static String AppiumURl = "http://127.0.0.1:4723/wd/hub";

    @Override
    protected void setUp() throws Exception
    {   super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:\\MobTest\\apks\\org.wikipedia_50372_apps.evozi.com.apk");

        driver = new AndroidDriver(new URL(AppiumURl), capabilities);
        this.rotateScreenPortrait();
    }

    @Override
    protected void tearDown() {
        // driver.quit();
    }
    public void rotateScreenPortrait()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }
    public void rotateScreenLendScape()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }
    public void InBackground()
    {
        driver.runAppInBackground(2);
    }
}
