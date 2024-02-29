package testCases.admin;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.admin.DashboardPage;
import pageObjects.admin.LoginPageAdmin;
import pageObjects.user.HomePage;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class TC_004_Admin_Navigate_ToLandingPage extends BaseTest{

    LoginPageAdmin loginPageAdmin = new LoginPageAdmin(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);
    HomePage homePage = new HomePage(driver);
    @Test
    public void navigateToLandingPage() throws InterruptedException, IOException {
        logger = LogManager.getLogger(this);

        logger.info("Test started..");

        loginPageAdmin.setUserName("admin");
        loginPageAdmin.setPassword("admin");
        logger.info("Valid Credentials entered..");

        loginPageAdmin.clickLoginBtn();
        logger.info("Clicked Login button..");
        Thread.sleep(2000);

        dashboardPage.closePopUp();
        logger.info("Closed popup Alert..");


        String originalWindow = driver.getWindowHandle();

        //Click the link which opens in a new window
        dashboardPage.clickProfileIcon();
        dashboardPage.clickStoreLink();
        logger.info("Clicked Profile Icon & Store page link..");
        Thread.sleep(4000);

        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Get the title of the opened page
        String pageTitle = homePage.getPageTitle();
        driver.switchTo().window(originalWindow);
        dashboardPage.clickLogout();


        if (pageTitle.equals("Your Store")){
            logger.info("Navigated to Store page & title is- "+homePage.getPageTitle());
            logger.info("Test case passed..");
        }else {
            logger.error("Test case failed..");
            captureScreen(driver,this.toString());
            Assert.fail();
        }
    }
}
