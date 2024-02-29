package pageObjects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProfilePage {
    By userName = By.name("username");
    By firstName = By.name("firstname");
    By lastName = By.name("lastname");
    By password = By.name("password");
    By conPassword = By.name("confirm");
    By saveBtn = By.xpath("//*[@id=\"content\"]/div[1]/div/div/button");
    By saveSuccess = By.xpath("//*[@id=\"content\"]/div[2]/div[1]");
    WebDriver driver;

    public EditProfilePage(WebDriver driver){
        this.driver = driver;
    }
    public void setUserName(String uName){
        driver.findElement(userName).clear();
        driver.findElement(userName).sendKeys(uName);
    }
    public void setFirstName(String fName){
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(fName);
    }
    public void setLastName(String lName){
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(lName);
    }
    public void setPassword(String passwordText){
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(passwordText);
    }
    public void setConPassword(String cPassText){
        driver.findElement(conPassword).clear();
        driver.findElement(conPassword).sendKeys(cPassText);
    }
    public void clickOnSaveBtn(){
        driver.findElement(saveBtn).click();
    }
    public boolean isSuccessAlertDisplay(){
        return driver.findElement(saveSuccess).isDisplayed();
    }
    public String successAlertMsg(){
        return driver.findElement(saveSuccess).getText();
    }
}
