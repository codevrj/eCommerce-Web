package testCases.user;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.user.HomePage;
import utilities.ExcelUtils;

import java.io.IOException;

public class TC_011_Search_Items extends BaseTest {
    HomePage homePage = new HomePage(driver);

    @Test(dataProvider = "searchDataProvider")
    public void searchItem(String searchText){
        logger = LogManager.getLogger(TC_011_Search_Items.class);

        homePage.searchItems(searchText);
        homePage.clickSearchBtn();
        logger.info("Search text entered and clicked search button..");
    }

    @AfterMethod
    public void searchReset(){
        homePage.clearSearch();
    }

    String xlSheet = "SearchData";
    ExcelUtils dt = new ExcelUtils(excelFilePath);

    // This method get data from the Excel file via the ExcelUtils class...
    @DataProvider(name = "searchDataProvider")
    public String[][] getData() throws IOException {

        int totRowNum = dt.getRowCount(xlSheet);
        int totColNum = dt.getCellCount(xlSheet, 1);

        String searchData[][] = new String[totRowNum][totColNum];

        for (int i = 1; i <= totRowNum; i++) {
            for (int j = 0; j < totColNum; j++) {
                searchData[i - 1][j] = dt.getCellData(xlSheet, i, j); // 1 row  0 column
            }
        }
        return searchData;
    }
}
