package us.piit.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    AppiumDriver driver;

    public LandingPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.rfi.sams.android:id/sign_in_button")
    @iOSFindBy(accessibility = "Sign In")
    private MobileElement btnSignIn;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageButton\").description(\"Sam's Club\")")
    private MobileElement btnHamburgerIcon;

    public SignInPage clickSignInBtn(){
        btnSignIn.click();
        return new SignInPage(driver);
    }


}
