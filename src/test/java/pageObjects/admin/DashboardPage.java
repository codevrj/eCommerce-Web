package pageObjects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DashboardPage {
    By popUp = By.xpath("//*[@id=\"modal-security\"]/div/div/div[1]/button");
    By logoutBtn = By.xpath("//*[@id=\"header\"]/div/ul/li[2]/a");
    By profileIcon = By.xpath("//*[@id=\"header\"]/div/ul/li[1]/a");
    By yourProfOption = By.xpath("//*[@id=\"header\"]/div/ul/li[1]/ul/li[1]/a");
    By storeLink = By.xpath("//*[@id=\"header\"]/div/ul/li[1]/ul/li[4]/a");
    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }
    public void closePopUp(){
        driver.findElement(popUp).click();
    }
    public void clickLogout(){
        driver.findElement(logoutBtn).click();
    }
    public void clickProfileIcon(){
        driver.findElement(profileIcon).click();
    }
    public void clickYourProfileOpt(){
        driver.findElement(yourProfOption).click();
    }
    public void clickStoreLink(){
        driver.findElement(storeLink).click();
    }
}
