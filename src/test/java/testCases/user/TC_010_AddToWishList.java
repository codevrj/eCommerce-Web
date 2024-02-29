package testCases.user;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.user.HomePage;
import pageObjects.user.LoginPage;
import pageObjects.user.WishListPage;

import java.io.IOException;
import java.util.Objects;

public class TC_010_AddToWishList extends BaseTest {

    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    WishListPage wishListPage = new WishListPage(driver);

    @Test
    public void addItemToWishList() throws IOException, InterruptedException {
        logger = LogManager.getLogger(this);
        logger.info("Test started..");

        loginPage.clickDropDown();
        loginPage.clickLoginLink();
        logger.info("Clicked on Login link");

        loginPage.setEmail("abyj@gmail.com");
        loginPage.setPassword("654321");
        logger.info("Entered valid credentials..");

        loginPage.clickLogin();
        logger.info("Clicked login button..");

        Thread.sleep(3000);

        if (Objects.equals(driver.getTitle(), "My Account")) {
            Assert.assertTrue(true);
            logger.info("Navigated My Account screen..");
        }else {
            logger.error("Error - Invalid Page Title..");
            captureScreen(driver, this.toString());
            Assert.fail();
        }

        loginPage.clickHomeLink();
        logger.info("Clicked Home link..");

        homePage.clickIPhoneWishList();
        logger.info("Clicked Iphone to wishlist..");
        homePage.clickWishList();
        logger.info("Go to wishlist page..");

        if (wishListPage.checkIphoneInWishList()){
            logger.info("Test Passed - Added Item displays in WishList..");
        }else {
            logger.error("Test Failed - Item not Listed in WishList page..");
            Assert.fail();
        }
    }
}
