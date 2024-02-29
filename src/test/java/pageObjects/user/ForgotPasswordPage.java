package pageObjects.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    By emailForgotPassword = By.xpath("//*[@id=\"input-email\"]");
    By emailSendConfirmAlert = By.xpath("//*[@id=\"account-login\"]/div[1]");
    By continueBtn = By.xpath("//*[@id=\"content\"]/form/div/div[2]/input");

    WebDriver driver;

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }
    public void setEmailForgotPassword(String emailText){
        driver.findElement(emailForgotPassword).sendKeys(emailText);
    }
    public void clickOnContinueBtn(){
        driver.findElement(continueBtn).click();
    }
    public boolean isSuccessAlertDisplayed(){
        return driver.findElement(emailSendConfirmAlert).isDisplayed();
    }
}
