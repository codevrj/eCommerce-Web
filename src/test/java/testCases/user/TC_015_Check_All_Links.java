package testCases.user;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.HttpURLConnection;
import java.net.*;
import java.util.List;

public class TC_015_Check_All_Links extends BaseTest {

    @Test
    public void checkBrokenLinks(){

        logger = LogManager.getLogger(this);

        List<WebElement> links = driver.findElements(By.tagName("a"));
        logger.info("Total links found: " + links.size());

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
