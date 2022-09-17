package base;

import drivers.WebDriverInit;
import hooks.WebDriverHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PageObject {

    //getDriver
    public WebDriver getDriver(){
        if (WebDriverInit.driver != null) {
            return WebDriverInit.driver;
        } else {
            new WebDriverHooks().intializeWebdriver();
            return WebDriverInit.driver;
        }
    }

    //find
    public WebElement find(By locator){
        return getDriver().findElement(locator);
    }

    //findAll
    public List<WebElement> findAll(By locator){
        return getDriver().findElements(locator);
    }

    //type
    public void type(By locator, CharSequence... text){
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
        element.sendKeys(Keys.RETURN);
    }

    public boolean isDisplayed(By locator) {
        WebElement element = find(locator);
        return element.isDisplayed();
    }

    //click
    public void click(By locator){
        find(locator).click();
    }

    public void rightClick(By locator){
        Actions actions = new Actions(getDriver());
        WebElement elementLocator = getDriver().findElement(locator);
        actions.doubleClick(elementLocator).perform();
    }

    //select
    public void selectByVisibleText(By locator, String text){
        WebElement element = find(locator);
        Select select = new Select(element);
        select.selectByVisibleText(text);

    }

    //openURL
    public void openUrl(String url){
        getDriver().get(url);
    }
}
