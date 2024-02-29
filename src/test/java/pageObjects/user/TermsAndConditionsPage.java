package pageObjects.user;

import org.openqa.selenium.WebDriver;

public class TermsAndConditionsPage {

    WebDriver driver;
    public TermsAndConditionsPage(WebDriver driver){
        this.driver = driver;
    }

    public String getPageTitle(){
        return driver.getTitle();
    }
}
