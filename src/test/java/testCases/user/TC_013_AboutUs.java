package testCases.user;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.user.HomePage;

public class TC_013_AboutUs extends BaseTest {
    HomePage homePage = new HomePage(driver);
    @Test
    public void checkAboutUsLink() throws InterruptedException {
        logger = LogManager.getLogger(TC_013_AboutUs.class);

        homePage.clickOnAboutUsLink();
        logger.info("Clicked on AboutUs link in Home page..");
        if (driver.getTitle().equals("About Us")){
            Assert.assertTrue(true);
            logger.info("Navigated to About Us page..");
        }else {
            logger.error("Not the About Us page..");
            Assert.fail();
        }
    }
}
