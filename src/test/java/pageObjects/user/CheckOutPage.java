package pageObjects.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {

    By firstName = By.xpath("//*[@id=\"input-payment-firstname\"]");
    By lastName = By.xpath("//*[@id=\"input-payment-lastname\"]");
    By company = By.xpath("//*[@id=\"input-payment-company\"]");
    By address1 = By.xpath("//*[@id=\"input-payment-address-1\"]");
    By address2 = By.xpath("//*[@id=\"input-payment-address-2\"]");
    By city = By.xpath("//*[@id=\"input-payment-city\"]");
    By postCode = By.xpath("//*[@id=\"input-payment-postcode\"]");
    By country = By.xpath("//*[@id=\"input-payment-country\"]");  //
    By region = By.xpath("//*[@id=\"input-payment-zone\"]"); //
    By continueBtn1 = By.xpath("//*[@id=\"button-payment-address\"]");
    By continueBtn2 = By.xpath("//*[@id=\"button-shipping-address\"]");
    By continueBtn3 = By.xpath("//*[@id=\"button-shipping-method\"]");
    By termsAndConditions = By.xpath("//*[@id=\"collapse-payment-method\"]/div/div[2]/div/input[1]");
    By continueBtn4 = By.xpath("//*[@id=\"button-payment-method\"]");
    By confirmBtn = By.xpath("//*[@id=\"button-confirm\"]");



    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String fName) {
        driver.findElement(firstName).sendKeys(fName);
    }

    public void setLastName(String lName) {
        driver.findElement(lastName).sendKeys(lName);
    }

    public void setCompany(String companyName) {
        driver.findElement(company).sendKeys(companyName);
    }

    public void setAddress1(String addressText1) {
        driver.findElement(address1).sendKeys(addressText1);
    }

    public void setAddress2(String addressText2) {
        driver.findElement(address2).sendKeys(addressText2);
    }

    public void setCity(String cityText) {
        driver.findElement(city).sendKeys(cityText);
    }

    public void setPostCode(String postCodeText) {
        driver.findElement(postCode).sendKeys(postCodeText);
    }

    public void setCountry(String countryName) {
        WebElement dropDownCountry = driver.findElement(country);
        Select select = new Select(dropDownCountry);
        select.selectByVisibleText(countryName);
    }

    public void setRegion(String regionName) {
        WebElement dropDownRegion = driver.findElement(region);
        Select select = new Select(dropDownRegion);
        select.selectByVisibleText(regionName);
    }

    public void clickContinueBtn1() {
        driver.findElement(continueBtn1).click();
    }
    public void clickContinueBtn2() {
        driver.findElement(continueBtn2).click();
    }
    public void clickContinueBtn3() {
        driver.findElement(continueBtn3).click();
    }
    public void clickTermsAndConditions(){
        driver.findElement(termsAndConditions).click();
    }
    public void clickContinueBtn4() {
        driver.findElement(continueBtn4).click();
    }
    public void clickConfirmBtn() {
        driver.findElement(confirmBtn).click();
    }

}
























