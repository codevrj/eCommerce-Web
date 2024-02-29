package testCases.user;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.user.RegisterPage;
import utilities.ExcelUtils;

import java.io.IOException;

public class TC_002_Customer_Registration_DDT extends BaseTest {

    RegisterPage registerPage = new RegisterPage(driver);


    @Test(dataProvider = "RegisterDataProvider")
    public void registrationDDT(String fName,String lName,String email,String tel,String pass,String conPass) throws InterruptedException {

        logger = LogManager.getLogger(TC_002_Customer_Registration_DDT.class);

        registerPage.clickDropDown();
        registerPage.clickRegister();
        logger.info("Goto Register page...");

        registerPage.setFirstName(fName);
        registerPage.setLastName(lName);
        registerPage.setEmail(email);
        registerPage.setTelephone(tel);
        registerPage.setPassword(pass);
        registerPage.setConfirmPassword(conPass);
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

    @AfterMethod
    public void logout() throws InterruptedException {
        registerPage.clickDropDownRegPage();
        registerPage.clickLogout();
        logger.info("Logged out...");
        Thread.sleep(2000);
    }

    //String excelFilePath = System.getProperty("user.dir")+"/src/test/java/testData/TestData.xlsx";
    String xlSheet = "RegisterData";
    ExcelUtils dt = new ExcelUtils(excelFilePath);

    // This method get data from the Excel file via the ExcelUtils class...
    @DataProvider(name = "RegisterDataProvider")
    public String[][] getData() throws IOException {

        int totRowNum = dt.getRowCount(xlSheet);
        int totColNum = dt.getCellCount(xlSheet, 1);

        String regData[][] = new String[totRowNum][totColNum];

        for (int i = 1; i <= totRowNum; i++) {
            for (int j = 0; j < totColNum; j++) {
                regData[i - 1][j] = dt.getCellData(xlSheet, i, j); // 1 row  0 column
            }
        }
        return regData;
    }
}
