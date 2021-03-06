import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class MyTest {
    public WebDriver driver;


    @BeforeClass
    public void beforeTest() {
        System.out.println("before test is called");

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("name", "Selenium Test Example");
        caps.setCapability("build", "1.0");
        caps.setCapability("browser_api_name", "Chrome39");
        caps.setCapability("os_api_name", "WinXPSP2-C2");
        caps.setCapability("screen_resolution", "1024x768");
        caps.setCapability("record_video", "true");
        caps.setCapability("record_network", "true");
        caps.setCapability("record_snapshot", "false");

        try {
            driver = new RemoteWebDriver(new URL("http://USERNAME:PASSWORD@hub.crossbrowsertesting.com:80/wd/hub"), caps);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public void afterTest() {
        if (driver!=null) {
            driver.quit();
        }
    }

    @Test
    public void myfirsttest() {


        System.out.println("Loading Url");
        driver.get("http://crossbrowsertesting.github.io/selenium_example_page.html");

        //maximize the window
        System.out.println("Maximizing window");
        driver.manage().window().maximize();

        //check the title
        System.out.println(driver.getTitle());

    }
}
