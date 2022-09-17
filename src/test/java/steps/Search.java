package steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Search {

    @Test
    public void search() throws InterruptedException {
        //setup chromedriver
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //setting chrome capabilities https://peter.sh/experiments/chromium-command-line-switches/
        options.addArguments("--start-maximized,--incognito");
        WebDriver driver = new ChromeDriver(options);
        //for mac it --start-maximized not working properly. So need use this command to maximize
        driver.manage().window().maximize();
        driver.get("https://music.youtube.com/");
        Thread.sleep(2000);

        WebElement search = driver.findElement(By.id("icon"));
        search.click();
        WebElement input = driver.findElement(By.xpath("//input[@class='style-scope ytmusic-search-box']"));
        Thread.sleep(2000);
        input.sendKeys("Dian Satro");
        input.sendKeys(Keys.ENTER);

    }

}
