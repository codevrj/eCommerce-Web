package pageObjects.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {

    By inquiry = By.xpath("//*[@id=\"input-enquiry\"]");
    By name = By.xpath("//*[@id=\"input-name\"]");
    By email = By.xpath("//*[@id=\"input-email\"]");
    By submitBtn = By.xpath("//*[@id=\"content\"]/form/div/div/input");

    WebDriver driver;

    public ContactUsPage(WebDriver driver){
        this.driver = driver;
    }
    public String checkName(){
        return driver.findElement(name).getText();
    }
    public String checkEmail(){
        return driver.findElement(email).getText();
    }
    public void setInquiryText(String inquiryText) {
        driver.findElement(inquiry).sendKeys(inquiryText);
    }
    public void clickSubmitBtn(){
        driver.findElement(submitBtn).click();
    }
}
