package testCases.user;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.user.HomePage;

public class TC_006_PrivacyPolicy extends BaseTest {
    HomePage homePage = new HomePage(driver);
    @Test
    public void checkPrivacyPolicyLink(){
        logger = LogManager.getLogger(TC_006_PrivacyPolicy.class);

        homePage.clickOnPrivacyPolicy();
        logger.info("Clicked the Privacy Policy link in Home page..");
        if (driver.getTitle().equals("Privacy Policy")){
            Assert.assertTrue(true);
            logger.info("Navigated to Privacy Policy page..");
        }else {
            logger.error("Not the Privacy Policy page..");
            Assert.fail();
        }
    }
}
