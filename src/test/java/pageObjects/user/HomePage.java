package pageObjects.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import testCases.user.BaseTest;

import static testCases.user.BaseTest.driver;

public class HomePage {

    By camera = By.xpath("//*[@id=\"content\"]/div[2]/div[4]/div/div[3]/button[1]");
    By iPhone = By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[3]/button[2]");
    By colorOptionSelect = By.xpath("//*[@id=\"input-option226\"]");
    By quantity = By.xpath("//*[@id=\"input-quantity\"]");
    By addToCartButton = By.xpath("//*[@id=\"button-cart\"]");
    By checkoutLink = By.xpath("//*[@id=\"top-links\"]/ul/li[5]/a");
    By contactUsLink = By.xpath("/html/body/footer/div/div/div[2]/ul/li[1]/a");
    By wishListLink = By.xpath("//*[@id=\"wishlist-total\"]/span");
    By aboutUsLink = By.xpath("/html/body/footer/div/div/div[1]/ul/li[1]/a");
    By privacyPolicy = By.xpath("/html/body/footer/div/div/div[1]/ul/li[3]/a");
    By termsAndConditions = By.xpath("/html/body/footer/div/div/div[1]/ul/li[4]/a");
    By search = By.name("search");
    By searchButton = By.xpath("//*[@id=\"search\"]/span/button");
    By deliveryInfo = By.xpath("/html/body/footer/div/div/div[1]/ul/li[2]/a");
    By mp3El = By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[8]/a");

//    @FindBy(xpath = "//*[@id=\"search\"]/span/button")
//            WebElement searchBtn;
//    @FindBy(name = "ss")
//            WebElement bnme;

    WebDriver driver;

//    public HomePage(WebDriver rdriver){
//        ldriver = rdriver;
//        PageFactory.initElements(rdriver,this);
//    }
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public void clickItem(){
        driver.findElement(camera).click();
    }
    public void selectColor(String colorText){
        WebElement dropdownColor = driver.findElement(colorOptionSelect);
        Select select = new Select(dropdownColor);
        select.selectByVisibleText(colorText);
    }
    public void setQuantity(String quantityText){
        driver.findElement(quantity).sendKeys(quantityText);
    }
    public void clearQuantity(){
        driver.findElement(quantity).clear();
    }
    public void clickAddCartButton(){
        driver.findElement(addToCartButton).click();
    }
    public void clickCheckOutLink(){
        driver.findElement(checkoutLink).click();
    }
    public void clickContactUs(){
        driver.findElement(contactUsLink).click();
    }
    public void clickIPhoneWishList(){
        driver.findElement(iPhone).click();
    }
    public void clickWishList(){
        driver.findElement(wishListLink).click();
    }
    public void clickOnAboutUsLink(){
        driver.findElement(aboutUsLink).click();
    }
    public void clickOnPrivacyPolicy(){
        driver.findElement(privacyPolicy).click();
    }
    public void clickOnTermsAndConditions(){
        driver.findElement(termsAndConditions).click();
    }
    public void searchItems(String sText){
        driver.findElement(search).sendKeys(sText);
    }
    public WebElement searchElm(){
        return driver.findElement(search);
    }
    public WebElement mp3elm(){
        return driver.findElement(mp3El);
    }
    public WebElement delInfo(){
        return driver.findElement(deliveryInfo);
    }
    public void clearSearch(){
        driver.findElement(search).clear();
    }
    public void clickSearchBtn(){
        driver.findElement(searchButton).click();
    }
    public String getPageTitle(){
        return driver.getTitle();
    }
    public void clickDeliveryInfoLink(){
        driver.findElement(deliveryInfo).click();
    }
}































