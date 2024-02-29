package pageObjects.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    WebDriver driver;
    By dropDown =  By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[2]");
    By dropDownRegPage =  By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]");
    By logout = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a");

    By registerLink = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a");
    By firstName = By.xpath("//*[@id=\"input-firstname\"]");
    By lastName = By.xpath("//*[@id=\"input-lastname\"]");
    By email = By.xpath("//*[@id=\"input-email\"]");
    By telephone = By.xpath("//*[@id=\"input-telephone\"]");
    By password = By.xpath("//*[@id=\"input-password\"]");
    By confirmPassword = By.xpath("//*[@id=\"input-confirm\"]");
    By privacyPolicy = By.xpath("//*[@id=\"content\"]/form/div/div/input[1]");
    By btnContinue = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
    By btnContinue2 = By.xpath("//*[@id=\"content\"]/div/div/a");

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickDropDown(){
        driver.findElement(dropDown).click();
    }
    public void clickRegister(){
        driver.findElement(registerLink).click();
    }
    public void setFirstName(String fname){
        driver.findElement(firstName).sendKeys(fname);
    }
    public void setLastName(String lname){
        driver.findElement(lastName).sendKeys(lname);
    }
    public void setEmail(String eml){
        driver.findElement(email).sendKeys(eml);
    }
    public void setTelephone(String tel){
        driver.findElement(telephone).sendKeys(tel);
    }
    public void setPassword(String passwd){
        driver.findElement(password).sendKeys(passwd);
    }
    public void setConfirmPassword(String conPass){
        driver.findElement(confirmPassword).sendKeys(conPass);
    }
    public void clickPrivacy(){
        driver.findElement(privacyPolicy).click();
    }
    public void clickBtnContinue(){
        driver.findElement(btnContinue).click();
    }
    public void clickBtnContinue2(){
        driver.findElement(btnContinue2).click();
    }

    public void clickDropDownRegPage(){
        driver.findElement(dropDownRegPage).click();
    }
    public void clickLogout(){
        driver.findElement(logout).click();
    }
}
