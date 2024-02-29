package testCases.user;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.user.RegisterPage;

public class TC_001_Customer_Registration extends BaseTest {
    RegisterPage registerPage = new RegisterPage(driver);

    @Test
    public void registration() throws InterruptedException {

        logger = LogManager.getLogger(TC_001_Customer_Registration.class);

        registerPage.clickDropDown();
        registerPage.clickRegister();
        logger.info("Goto Register page...");

        registerPage.setFirstName("Joe");
        registerPage.setLastName("Growely");
        registerPage.setEmail("jdgs@gmail.com");
        registerPage.setTelephone("0112548647");
        registerPage.setPassword("123456");
        registerPage.setConfirmPassword("123456");
        logger.info("Enter all Registration details...");
        registerPage.clickPrivacy();
        logger.info("Clicked on privacy checkbox...");
        Thread.sleep(2000);
        registerPage.clickBtnContinue();
        logger.info("Clicked on continue button...");
        Thread.sleep(2000);
        //Assert.assertEquals("Customer Registration Successful",driver.getTitle());
        registerPage.clickBtnContinue2();
        logger.info("Clicked on 2nd continue button...");
        Thread.sleep(2000);

        Assert.assertEquals(driver.getTitle(),"My Account");
        logger.info("Successfully Registered & navigated page");
    }
}
