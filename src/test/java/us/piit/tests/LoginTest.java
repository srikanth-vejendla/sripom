package us.piit.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import us.piit.pages.LandingPage;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    AppiumDriver driver;

    @Before
    public void setUp() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("browserName","");

        if(System.getProperty("platformName").equals("ios")){
            capabilities.setCapability("platformName","iOS");
            capabilities.setCapability("platformVersion","10.3");
            capabilities.setCapability("autoAcceptAlerts",true);
            capabilities.setCapability("deviceName","iPhone Simulator");
//            capabilities.setCapability("app","/Users/s0v0023/Desktop/SamsClub.app");
            capabilities.setCapability("bundleId","com.samsclub.samsapp");

            driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        }else{
            capabilities.setCapability("platformName","Android");
            capabilities.setCapability("platformVersion","7.0");
            capabilities.setCapability("deviceName","Android Emulator");
//            capabilities.setCapability("app","/Users/s0v0023/Desktop/sams.apk");
            capabilities.setCapability("appPackage","com.rfi.sams.android");
            capabilities.setCapability("appActivity",".main.SplashActivity");

            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void loginWithValidCredentials(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickSignInBtn().doValidLogin("test123@yahoo.com","hjdfhjhjdh");
    }
}

