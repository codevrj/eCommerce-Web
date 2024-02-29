package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasicActions {

    // Example 1: Mouse Hover
    public static void mouseHover(WebDriver driver,WebElement elm){
        Actions action = new Actions(driver);
        action.moveToElement(elm).perform();
    }

    // Example 2: Right Click
    public static void rightClick(WebDriver driver,WebElement elm){
        Actions action = new Actions(driver);
        action.contextClick(elm).perform();
    }

    // Example 3: Double Click
    public static void doubleClick(WebDriver driver,WebElement elm){
        WebElement doubleClickElement = driver.findElement(By.id("doubleClickElementId"));
        Actions action = new Actions(driver);
        action.doubleClick(doubleClickElement).perform();
    }


    // Example 4: Click and Hold
    public static void clickAndHold(WebDriver driver,WebElement elm){
        WebElement clickAndHoldElement = driver.findElement(By.id("clickAndHoldElementId"));
        Actions action = new Actions(driver);
        action.clickAndHold(clickAndHoldElement).perform();
    }


    // Example 5: Drag and Drop
    public static void dragAndDrop(WebDriver driver,WebElement sourceElm,WebElement targetElm){
        WebElement sourceElement = driver.findElement(By.id("sourceElementId"));
        WebElement targetElement = driver.findElement(By.id("targetElementId"));
        Actions action = new Actions(driver);
        action.dragAndDrop(sourceElement, targetElement).perform();
    }


    // Example 6: Keyboard Actions - Send Keys
    public static void keyboardSendKeys(WebDriver driver,WebElement elm) {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
    }

    // Example 7: Keyboard Actions - Key Down
    public static void keyboardKeyDown(WebDriver driver,WebElement elm) {
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
    }

    // Example 8: Keyboard Actions - Key Up
    public static void keyboardKeyUp(WebDriver driver){
        Actions action = new Actions(driver);
        action.keyUp(Keys.CONTROL).perform();
    }

    // Example 9: Scrolling to Element
    public static void scrollToElement(WebDriver driver,WebElement elm){
        Actions action = new Actions(driver);
        action.moveToElement(elm).perform();
    }

    // Example 10: Scrolling to Bottom of the Page
    public static void scrollToBottomOfPage(WebDriver driver){
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).perform();
    }

}
