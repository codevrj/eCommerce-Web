package testCases.user;

import org.testng.annotations.Test;
import pageObjects.user.ChangePasswordPage;
import pageObjects.user.LoginPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TC_009_Change_Password extends BaseTest {
    LoginPage loginPage = new LoginPage(driver);
    ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);

    @Test
    public void changePassword(){
        loginPage.clickDropDown();
        loginPage.clickLoginLink();
        logger.info("Clicked on Login link");

        loginPage.setEmail("abyj@gmail.com");
        loginPage.setPassword("123456");
        logger.info("Entered valid credentials..");

        loginPage.clickLogin();
        logger.info("Clicked login button..");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        loginPage.clickChangePasswordLink();
        logger.info("Clicked Change Password link..");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        changePasswordPage.setPassword("654321");
        changePasswordPage.setConfirmPassword("654321");
        logger.info("Entered New password & confirm password..");
        changePasswordPage.clickContinueBtn();
        logger.info("Clicked on continue button..");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
    }
}
