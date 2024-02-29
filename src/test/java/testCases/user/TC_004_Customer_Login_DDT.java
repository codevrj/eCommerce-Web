package testCases.user;

import org.apache.logging.log4j.LogManager;
import utilities.ExcelUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.user.LoginPage;

import java.io.IOException;

public class TC_004_Customer_Login_DDT extends BaseTest {

    LoginPage loginPage = new LoginPage(driver);

    @Test(dataProvider = "LoginDataProvider")
    public void loginTest(String username, String password){

        logger = LogManager.getLogger(TC_004_Customer_Login_DDT.class);
        logger.info("Test started..");

        loginPage.clickDropDown();
        loginPage.clickLoginLink();
        logger.info("Clicked on Login link");

        loginPage.setEmail(username);
        loginPage.setPassword(password);
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

    //String excelFilePath = System.getProperty("user.dir")+"/src/test/java/testData/TestData.xlsx";
    String xlSheet = "LoginData";
    ExcelUtils dt = new ExcelUtils(excelFilePath);

    // This method get data from the Excel file via the ExcelUtils class...
    @DataProvider(name = "LoginDataProvider")
    public String[][] getData() throws IOException {

        int totRowNum = dt.getRowCount(xlSheet);
        int totColNum = dt.getCellCount(xlSheet, 1);

        String loginData[][] = new String[totRowNum][totColNum];

        for (int i = 1; i <= totRowNum; i++) {
            for (int j = 0; j < totColNum; j++) {
                loginData[i - 1][j] = dt.getCellData(xlSheet, i, j); // 1 row  0 column
            }
        }
        return loginData;
    }
}





























