package testCases.admin;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageObjects.admin.DashboardPage;
import pageObjects.admin.LoginPageAdmin;

import java.io.IOException;
import java.time.Duration;

public class TC_001_Admin_Login extends BaseTest{
    LoginPageAdmin loginPageAdmin = new LoginPageAdmin(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);

    @Test
    public void loginTest() throws InterruptedException {

        logger = LogManager.getLogger(TC_001_Admin_Login.class);

        logger.info("Test started..");

        loginPageAdmin.setUserName("admin");
        loginPageAdmin.setPassword("admin");
        logger.info("Valid Credentials entered..");

        loginPageAdmin.clickLoginBtn();
        logger.info("Clicked Login button..");
        //Thread.sleep(2000);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        dashboardPage.closePopUp();
        logger.info("Closed popup Alert..");
    }

    @AfterMethod
    public void logout() throws InterruptedException, IOException {
        Thread.sleep(2000);
        dashboardPage.clickLogout();
        logger.info("Clicked LogOut button..");
        if (loginPageAdmin.isLoginPageTitle()){
            logger.info("Log Out successfully..& Navigated to Login page..");
        }else {
            logger.error("Unable to Logout..");
            captureScreen(driver,"TC_001_Admin_Login");
            Assert.fail();
        }
    }
}
