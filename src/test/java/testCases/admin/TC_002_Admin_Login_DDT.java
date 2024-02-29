package testCases.admin;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.admin.DashboardPage;
import pageObjects.admin.LoginPageAdmin;
import utilities.ExcelUtils;

import java.io.IOException;

public class TC_002_Admin_Login_DDT extends BaseTest{

    LoginPageAdmin loginPageAdmin = new LoginPageAdmin(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);

    @Test(dataProvider = "LoginDataProvider")
    public void loginTest(String username, String password) throws InterruptedException {

        logger = LogManager.getLogger(this);

        logger.info("Test started..");

        loginPageAdmin.setUserName(username);
        loginPageAdmin.setPassword(password);
        logger.info("Valid Credentials entered..");

        loginPageAdmin.clickLoginBtn();
        logger.info("Clicked Login button..");
        Thread.sleep(2000);

        dashboardPage.closePopUp();
        logger.info("Closed popup Alert..");
    }

    @AfterMethod
    public void logout() throws InterruptedException, IOException {
        Thread.sleep(2000);
        dashboardPage.clickLogout();
        logger.info("Clicked LogOut button..");
        if (loginPageAdmin.isLoginPageTitle()){
            logger.info("Log Out successfully..& Navigated to Login page..");
        }else {
            logger.error("Unable to Logout..");
            captureScreen(driver,"TC_002_Admin_Login_DDT");
            Assert.fail();
        }
    }

    String xlSheet = "LoginData";
    ExcelUtils dt = new ExcelUtils(excelFilePath);

    // This method get data from the Excel file via the ExcelUtils class...
    @DataProvider(name = "LoginDataProvider")
    public String[][] getData() throws IOException {

        int totRowNum = dt.getRowCount(xlSheet);
        int totColNum = dt.getCellCount(xlSheet, 1);

        String[][] loginData = new String[totRowNum][totColNum];

        for (int i = 1; i <= totRowNum; i++) {
            for (int j = 0; j < totColNum; j++) {
                loginData[i - 1][j] = dt.getCellData(xlSheet, i, j); // 1 row  0 column
            }
        }
        return loginData;
    }
}



