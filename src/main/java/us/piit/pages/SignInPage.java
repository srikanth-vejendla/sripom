package us.piit.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    AppiumDriver driver;

    public SignInPage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.rfi.sams.android:id/sign_in_username")
    @iOSFindBy(accessibility = "Email Address")
    private MobileElement etUserName;

    @AndroidFindBy(id = "com.rfi.sams.android:id/sign_in_password")
    @iOSFindBy(accessibility = "Enter Password")
    private MobileElement etPassword;

    @AndroidFindBy(id = "com.rfi.sams.android:id/sign_in_button")
    @iOSFindBy(accessibility = "Sign In Button")
    private MobileElement btnSignIn;


    public HomePage doValidLogin(String username, String password){
        etUserName.sendKeys(username);
        etPassword.sendKeys(password);
        btnSignIn.click();
        return new HomePage(driver);
    }

    public SignInPage doInvalidLogin(String username, String password){
        etUserName.sendKeys(username);
        etPassword.sendKeys(password);
        btnSignIn.click();
        return this;
    }

}
