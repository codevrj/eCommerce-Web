package testCases.admin;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.admin.LoginPageAdmin;

import java.io.IOException;

public class TC_003_Admin_Invalid_Login extends BaseTest{
    LoginPageAdmin loginPageAdmin = new LoginPageAdmin(driver);

    @Test
    public void invalidLoginTest() throws InterruptedException, IOException {

        logger = LogManager.getLogger(TC_003_Admin_Invalid_Login.class);

        logger.info("Test started..");

        loginPageAdmin.setUserName("asfdr");
        loginPageAdmin.setPassword("12345");
        logger.info("Invalid Credentials entered..");

        loginPageAdmin.clickLoginBtn();
        logger.info("Clicked Login button..");
        Thread.sleep(2000);
        //driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        if (loginPageAdmin.isErrorAlertDisplay()){
            logger.info("Alert Message - "+loginPageAdmin.errorAlertText());
            logger.info("Test Case passed - Error Alert displayed..");
        }else {
            logger.error("Error Alert not displayed..");
            captureScreen(driver,"TC_002_Admin_Invalid_Login");
            Assert.fail();
        }
    }
}
