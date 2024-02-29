package pageObjects.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListPage {
    By iphoneItem = By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr[1]/td[2]/a");

    WebDriver driver;
    public WishListPage(WebDriver driver){
        this.driver = driver;
    }
    public boolean checkIphoneInWishList(){
        return driver.findElement(iphoneItem).isDisplayed();
    }
}
