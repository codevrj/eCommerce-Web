package testCases.user;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.user.DeliveryInformationPage;
import pageObjects.user.HomePage;
import pageObjects.user.LoginPage;

import java.io.IOException;

public class TC_014_Delivery_Information extends BaseTest{
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    DeliveryInformationPage deliveryInformationPage = new DeliveryInformationPage(driver);
    @Test
    public void checkDeliveryInfo() throws IOException {
        logger = LogManager.getLogger(this);

        logger.info("Test started..");

        loginPage.clickDropDown();
        loginPage.clickLoginLink();
        logger.info("Clicked on Login link");

        loginPage.setEmail("wsmith@gmail.com");
        loginPage.setPassword("stuvwx");
        logger.info("Entered valid credentials..");

        loginPage.clickLogin();
        logger.info("Clicked login button..");

        homePage.clickDeliveryInfoLink();
        logger.info("Clicked Delivery Information Link in Footer..");

        String expectedPageTitle = "Delivery Information";
        if (deliveryInformationPage.getTitleText().equals(expectedPageTitle)){
            logger.info("Page title as Expected. & Title is- "+deliveryInformationPage.getTitleText());
            logger.info("Test Case Passed..");
        }else {
            logger.error("Test Case failed..");
            Assert.fail();
            captureScreen(driver,this.toString());
        }
    }
}
