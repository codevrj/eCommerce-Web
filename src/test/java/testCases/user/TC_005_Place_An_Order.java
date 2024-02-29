package testCases.user;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;
import pageObjects.user.CheckOutPage;
import pageObjects.user.HomePage;
import pageObjects.user.LoginPage;

public class TC_005_Place_An_Order extends BaseTest {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    CheckOutPage checkOutPage = new CheckOutPage(driver);

    @Test
    public void placeAnOrder() throws InterruptedException {

        logger = LogManager.getLogger(TC_005_Place_An_Order.class);

        loginPage.clickDropDown();
        loginPage.clickLoginLink();
        loginPage.setEmail("wsmith@gmail.com");
        loginPage.setPassword("stuvwx");
        loginPage.clickLogin();
        Thread.sleep(2000);
        loginPage.clickHomeLink();

        homePage.clickItem();
        homePage.selectColor("Red");
        homePage.clearQuantity();
        Thread.sleep(4000);
        homePage.setQuantity("1");
        Thread.sleep(4000);
        homePage.clickAddCartButton();
        homePage.clickCheckOutLink();
        Thread.sleep(4000);

        checkOutPage.setFirstName("John");
        checkOutPage.setLastName("Paul");
        checkOutPage.setCompany("ABC pvt Ltd");
        checkOutPage.setAddress1("City Road, CA");
        checkOutPage.setAddress2("CA city");
        checkOutPage.setCity("CA North");
        checkOutPage.setPostCode("225010");
        checkOutPage.setCountry("Australia");
        checkOutPage.setRegion("Victoria");
        checkOutPage.clickContinueBtn1();
        checkOutPage.clickContinueBtn2();
        checkOutPage.clickContinueBtn3();
        checkOutPage.clickTermsAndConditions();
        checkOutPage.clickContinueBtn4();
        checkOutPage.clickConfirmBtn();

    }

/**    public double vatAmount() {
        double vatPrice = 0;
        double subTotal = 80;
        return subTotal * 20 / 100;
    }
 */

}
