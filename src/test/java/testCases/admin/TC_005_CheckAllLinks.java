package testCases.admin;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.admin.DashboardPage;
import pageObjects.admin.LoginPageAdmin;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class TC_005_CheckAllLinks extends BaseTest{

    LoginPageAdmin loginPageAdmin = new LoginPageAdmin(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);
    @Test
    public void checkAllLinks(){
        logger = LogManager.getLogger(this);

        logger.info("Test started..");

        loginPageAdmin.setUserName("admin");
        loginPageAdmin.setPassword("admin");
        logger.info("Valid Credentials entered..");

        loginPageAdmin.clickLoginBtn();
        logger.info("Clicked Login button..");
        dashboardPage.closePopUp();

        List<WebElement> links = driver.findElements(By.tagName("a"));

        logger.info("Total links found: " + links.size());
        //System.out.println("Total links found: " + links.size());

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                verifyLink(url);
            }
        }
    }
    public static void verifyLink(String url) {
        try {

            URI uri = URI.create(url);
//            HttpRequest request = HttpRequest.newBuilder()
//                    .HEAD().
//                    uri(uri)
//                    .build();

            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();

            int responseCode = connection.getResponseCode();

            if (responseCode >= 400) {
                logger.error(url + " is a broken link. Response Code: " + responseCode);
                Assert.fail(url + " is a broken link. Response Code: " + responseCode);
            } else {
                logger.info(url + " is a valid link. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            logger.error(url +" - Test Case failed..."+ " failed to connect. Error message: " + e.getMessage());
            Assert.fail(url + " failed to connect. Error message: " + e.getMessage());
        }
    }
}
