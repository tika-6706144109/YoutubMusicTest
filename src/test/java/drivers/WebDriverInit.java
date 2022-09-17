package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverInit {

    public static WebDriver driver;

    public static void initialize() {

        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //setting chrome capabilities https://peter.sh/experiments/chromium-command-line-switches/
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        //for mac it --start-maximized not working properly. So need use this command to maximize
        driver.manage().window().maximize();
    }

    public static void quite(){
        driver.quit();
    }
}
