package testCases.user;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.user.ContactUsPage;
import pageObjects.user.HomePage;
import pageObjects.user.LoginPage;

import java.time.Duration;

public class TC_008_Contact_Us_Inquiry extends BaseTest {
    HomePage homePage = new HomePage(driver);
    ContactUsPage contactUsPage = new ContactUsPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void inquirySend(){

        loginPage.clickDropDown();
        loginPage.clickLoginLink();
        logger.info("Clicked on Login link");

        loginPage.setEmail("abyj@gmail.com");
        loginPage.setPassword("123456");
        logger.info("Entered valid credentials..");

        loginPage.clickLogin();
        logger.info("Clicked login button..");

        //Assert.assertEquals(driver.getTitle(),"My Account");
        loginPage.clickHomeLink();
        logger.info("Clicked Home link..");


        homePage.clickContactUs();
        logger.info("Clicked on ContactUs link..");
        Assert.assertEquals(driver.getTitle(),"Contact Us");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

        String name = contactUsPage.checkName();
        String email = contactUsPage.checkEmail();

        //Assert.assertEquals(name,"Abby");
        //Assert.assertEquals(email,"abyj@gmail.com");

        contactUsPage.setInquiryText("This is a test inquiry");
        logger.info("Entered the inquiry text..");

        contactUsPage.clickSubmitBtn();
        logger.info("Clicked on the submit button..");
    }
}
