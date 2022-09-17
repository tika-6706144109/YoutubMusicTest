package hooks;

import drivers.WebDriverInit;
import io.cucumber.java.Scenario;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class WebDriverHooks {

    @Before
    public void intializeWebdriver(){
        WebDriverInit.initialize();
    }

    @After
    public void quitWebDriver(Scenario scenario) throws InterruptedException {
        Thread.sleep(5000);
        if(scenario.isFailed()){
            TakesScreenshot screenshot = (TakesScreenshot) WebDriverInit.driver;
            byte[] imageByte = screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(imageByte, "image/png", scenario.getId());
        }
        WebDriverInit.quite();


    }
}
