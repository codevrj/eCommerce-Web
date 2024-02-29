package testCases.user;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageObjects.user.LoginPage;

public class TC_003_Customer_Login extends BaseTest {
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void loginTest(){

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

        //Assert.assertEquals(driver.getTitle(),"My Account");
        loginPage.clickHomeLink();
        logger.info("Clicked Home link..");
    }

    @AfterMethod
    public void logout(){
        loginPage.clickDropDown();
        loginPage.clickLogOut();
        logger.info("Clicked logout button...");
        loginPage.clickLogOutContinueBtn();
        logger.info("Clicked logout continue button...");
    }
}
