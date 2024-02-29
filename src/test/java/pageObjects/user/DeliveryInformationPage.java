package pageObjects.user;

import org.openqa.selenium.WebDriver;

public class DeliveryInformationPage {

    WebDriver driver;

    public DeliveryInformationPage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitleText(){
        return driver.getTitle();
    }
}
