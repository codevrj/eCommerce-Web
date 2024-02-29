package pageObjects.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPage {
    By password = By.xpath("//*[@id=\"input-password\"]");
    By confirmPassword = By.xpath("//*[@id=\"input-confirm\"]");
    By continueBtn = By.xpath("//*[@id=\"content\"]/form/div/div[2]/input");

    WebDriver driver;
    public ChangePasswordPage(WebDriver driver){
        this.driver = driver;
    }
    public void setPassword(String passText){
        driver.findElement(password).sendKeys(passText);
    }
    public void setConfirmPassword(String conPassText){
        driver.findElement(confirmPassword).sendKeys(conPassText);
    }
    public void clickContinueBtn(){
        driver.findElement(continueBtn).click();
    }
}
