package testCases.user;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.user.ForgotPasswordPage;
import pageObjects.user.LoginPage;
import utilities.ExcelUtils;

import java.io.IOException;

public class TC_012_Forgot_Password extends BaseTest {
    LoginPage loginPage = new LoginPage(driver);
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

    @Test(dataProvider = "EmailDataProvider")
    public void checkForgotPassword(String emailText) throws IOException {

        logger = LogManager.getLogger(TC_012_Forgot_Password.class);

        logger.info("Test started..");

        loginPage.clickDropDown();
        loginPage.clickLoginLink();
        logger.info("Clicked on Login link");

        loginPage.clickForgotPasswordLink();
        logger.info("Clicked Forgot Password Link");

        forgotPasswordPage.setEmailForgotPassword(emailText);
        logger.info("Entered Email..");
        forgotPasswordPage.clickOnContinueBtn();
        logger.info("Clicked on continue button..");

        if (forgotPasswordPage.isSuccessAlertDisplayed()){
            logger.info("Alert displayed - An email with a confirmation link has been sent your email address.");
            Assert.assertTrue(true);
        }else {
            captureScreen(driver, "TC_012_Forgot_Password");
            logger.error("Success Alert not displayed..");
            Assert.fail("TC_012_Forgot_Password Test case failed..");
        }
    }

    String xlSheet = "EmailData";
    ExcelUtils dt = new ExcelUtils(excelFilePath);

    // This method get data from the Excel file via the ExcelUtils class...
    @DataProvider(name = "EmailDataProvider")
    public String[][] getData() throws IOException {

        int totRowNum = dt.getRowCount(xlSheet);
        int totColNum = dt.getCellCount(xlSheet, 1);

        String emailData[][] = new String[totRowNum][totColNum];

        for (int i = 1; i <= totRowNum; i++) {
            for (int j = 0; j < totColNum; j++) {
                emailData[i - 1][j] = dt.getCellData(xlSheet, i, j); // 1 row  0 column
            }
        }
        return emailData;
    }
}
