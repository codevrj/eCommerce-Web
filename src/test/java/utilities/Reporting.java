package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends TestListenerAdapter {
    public ExtentSparkReporter extentSparkReporter;
    public ExtentReports extent;
    public ExtentTest logger;

    public void onStart(ITestContext testContext){
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // timestamp..
        String reportName = "Test-Report-"+timeStamp+".html";
        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+reportName); // specify the location
        try {
            extentSparkReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        extent = new ExtentReports();

        extent.attachReporter(extentSparkReporter);
        extent.setSystemInfo("Host name","localhost");
        extent.setSystemInfo("Environment","QA");
        extent.setSystemInfo("user","Viraj");

        extentSparkReporter.config().setDocumentTitle("OpenCart eCommerce Test project");  // Title of the report
        extentSparkReporter.config().setReportName("Functional Test Automation Report"); // Name of the project
        //extentSparkReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        extentSparkReporter.config().setTheme(Theme.DARK);
    }

    public void onTestSuccess(ITestResult testResult){

        logger = extent.createTest(testResult.getName());  // create new entry in the report
        logger.log(Status.PASS, MarkupHelper.createLabel(testResult.getName(), ExtentColor.GREEN));  // send passed information
    }

    public void onTestFailure(ITestResult testResult){
        logger=extent.createTest(testResult.getName()); // create new entry
        logger.log(Status.FAIL,MarkupHelper.createLabel(testResult.getName(),ExtentColor.RED));

        String screenShotPath = System.getProperty("user.dir")+"\\Screenshots\\"+testResult.getName()+".png";

        File file = new File(screenShotPath);

        if (file.exists()){
            try {
                logger.fail("Screenshot is below:"+ logger.addScreenCaptureFromPath(screenShotPath));
            }catch (Exception e){
                System.out.println("Error "+e.getMessage()+" occurred.");
            }
        }
    }

    public void onTestSkipped(ITestResult testResult){
        logger = extent.createTest(testResult.getName());
        logger.log(Status.SKIP,MarkupHelper.createLabel(testResult.getName(),ExtentColor.ORANGE));
    }

    public void onFinish(ITestContext testContext){
        extent.flush();
    }

}
