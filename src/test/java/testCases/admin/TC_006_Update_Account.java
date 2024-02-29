package testCases.admin;

import org.apache.logging.log4j.LogManager;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.admin.DashboardPage;
import pageObjects.admin.EditProfilePage;
import pageObjects.admin.LoginPageAdmin;

import java.io.IOException;
import java.time.Duration;

public class TC_006_Update_Account extends BaseTest{
    LoginPageAdmin loginPageAdmin = new LoginPageAdmin(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);
    EditProfilePage editProfilePage = new EditProfilePage(driver);

    @Test
    public void updateProfileWithValidInputs() throws InterruptedException, IOException {

        logger = LogManager.getLogger(this);

        logger.info("Test started..");

        loginPageAdmin.setUserName("admin");
        loginPageAdmin.setPassword("admin");
        logger.info("Valid Credentials entered..");

        loginPageAdmin.clickLoginBtn();
        logger.info("Clicked Login button..");
        Thread.sleep(2000);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        dashboardPage.closePopUp();
        logger.info("Closed popup Alert..");

        dashboardPage.clickProfileIcon();
        dashboardPage.clickYourProfileOpt();
        Thread.sleep(3000);
        logger.info("Clicked 'Your Profile' option..");

        editProfilePage.setUserName("admin1");
        editProfilePage.setFirstName("John1");
        editProfilePage.setLastName("Doe1");
        editProfilePage.setPassword("admin1");
        editProfilePage.setConPassword("admin1");
        editProfilePage.clickOnSaveBtn();

        String successAlert = " Success: You have modified your profile! ";
        if (editProfilePage.isSuccessAlertDisplay()){
            logger.info("Save Success Alert is displayed..");
            logger.info("Alert Message - "+editProfilePage.successAlertMsg());
            //Assert.assertEquals(editProfilePage.successAlertMsg(),successAlert);
        }else {
            logger.error("Save Success Alert is not displayed..");
            captureScreen(driver, this.toString());
            Assert.fail();
        }
        dashboardPage.clickLogout();
    }
}
