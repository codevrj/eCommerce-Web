package pageObjects.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By dropDown =  By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]");
    By loginLink = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a");
    By email = By.xpath("//*[@id=\"input-email\"]");
    By password = By.xpath("//*[@id=\"input-password\"]");
    By btnLogin = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
    By homeLink = By.xpath("//*[@id=\"account-account\"]/ul/li[1]/a");
    By logOutLink = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a");
    By logoutContinueBtn = By.xpath("//*[@id=\"content\"]/div/div/a");
    By changePasswordLink = By.xpath("//*[@id=\"content\"]/ul[1]/li[2]/a");
    By forgotPasswordLink = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/div[2]/a");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickDropDown(){
        driver.findElement(dropDown).click();
    }
    public void clickLoginLink(){
        driver.findElement(loginLink).click();
    }
    public void setEmail(String emailText){
        driver.findElement(email).sendKeys(emailText);
    }

    public void setPassword(String passText){
        driver.findElement(password).sendKeys(passText);
    }
    public void clickLogin(){
        driver.findElement(btnLogin).click();
    }
    public void clickHomeLink(){
        driver.findElement(homeLink).click();
    }
    public void clickLogOut(){
        driver.findElement(logOutLink).click();
    }
    public void clickLogOutContinueBtn(){
        driver.findElement(logoutContinueBtn).click();
    }
    public void clickChangePasswordLink(){
        driver.findElement(changePasswordLink).click();
    }
    public void clickForgotPasswordLink(){
        driver.findElement(forgotPasswordLink).click();
    }
}
