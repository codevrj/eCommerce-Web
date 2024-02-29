package testCases.user;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import utilities.ExcelUtils;
import utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Objects;

public class BaseTest {
    ReadConfig readConfig = new ReadConfig(); // create obj to get appURL
    String baseUrl = readConfig.getUserAppUrl();  //Get app URL
    String excelFilePath = readConfig.getUserExcelPath(); //Get Excel file path

    public static WebDriver driver = new FirefoxDriver();

    public static Logger logger; // Add logger for all TestCases logging--

//    @Parameters("browser")
    @BeforeClass
    public void setup() throws InterruptedException {

//        if (brw.equalsIgnoreCase("chrome")){
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//        } else if (brw.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        } else if (brw.equalsIgnoreCase("edge")) {
//            WebDriverManager.edgedriver().setup();
//            driver = new EdgeDriver();
//        } else if (brw.equalsIgnoreCase("opera")){
//            WebDriverManager.operadriver().setup();
//        } else if (brw.equalsIgnoreCase("safari")) {
//            WebDriverManager.safaridriver().setup();
//            driver = new SafariDriver();
//        }

        Thread.sleep(3000);
        WebDriverManager.firefoxdriver().setup();
        driver.get(baseUrl);
        driver.manage().window().maximize();

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


    // For Random String & Numbers-----
/**  public String randomestring()
    {
        String generatedstring= RandomStringUtils.randomAlphabetic(8);
        return(generatedstring);
    }

    public static String randomeNum() {
        String generatedString2 = RandomStringUtils.randomNumeric(4);
        return (generatedString2);
    }
*/
}
