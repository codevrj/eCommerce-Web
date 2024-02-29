package testCases.admin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import utilities.ReadConfig;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    ReadConfig readConfig = new ReadConfig(); // create obj to get appURL
    String baseUrl = readConfig.getAdminAppUrl();  //Get Admin-app URL
    String excelFilePath = readConfig.getAdminExcelPath(); //Get Excel file path

    public static WebDriver driver = new FirefoxDriver();

    public static Logger logger = LogManager.getLogger(); // Add logger for all TestCases logging--

    @BeforeClass
    public void setup() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverManager.firefoxdriver().setup();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
    public void captureScreen(WebDriver driver, String testCaseName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + testCaseName + ".png");
        FileUtils.copyFile(source,target);
        System.out.println("Screenshot taken...");
    }

//    @AfterSuite
//    public void quit(){
//        System.exit(0);
//    }
}
