package pageObjects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageAdmin {
    By userName = By.name("username");
    By password = By.name("password");
    By loginBtn = By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button");
    By errorAlert = By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/div");
    WebDriver driver;

    public LoginPageAdmin(WebDriver driver){
        this.driver = driver;
    }

    public void setUserName(String userNameText) {
        driver.findElement(userName).sendKeys(userNameText);
    }
    public void setPassword(String passwordText) {
        driver.findElement(password).sendKeys(passwordText);
    }
    public void clickLoginBtn(){
        driver.findElement(loginBtn).click();
    }
    public boolean isLoginPageTitle(){
        return driver.getTitle().equals("Administration");
    }
    public String errorAlertText(){
        return driver.findElement(errorAlert).getText();
    }
    public boolean isErrorAlertDisplay(){
        return driver.findElement(errorAlert).isDisplayed();
    }
}
