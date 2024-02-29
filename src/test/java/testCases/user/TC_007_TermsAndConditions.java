package testCases.user;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.user.HomePage;
import pageObjects.user.TermsAndConditionsPage;

public class TC_007_TermsAndConditions extends BaseTest{

    HomePage homePage = new HomePage(driver);
    TermsAndConditionsPage tcPage = new TermsAndConditionsPage(driver);

    @Test
    public void checkTermsAndConditionsLink(){
        logger = LogManager.getLogger(this);

        homePage.clickOnTermsAndConditions();
        logger.info("Clicked the Terms and Conditions link in Home page..");
        if (tcPage.getPageTitle().equals("Terms & Conditions")){
            Assert.assertTrue(true);
            logger.info("Navigated to 'Terms & Conditions' page..");
        }else {
            logger.error("Not the 'Terms & Conditions' page..");
            Assert.fail();
        }
    }
}
