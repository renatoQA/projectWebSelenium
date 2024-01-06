package integration.factory.web.enums;

import io.github.bonigarcia.wdm.WebDriverManager;
import integration.factory.interfaces.ApplicationWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;
import java.io.File;

public enum Web implements ApplicationWeb {


    CHROME {
        @Override
        public WebDriver getDriver() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--window-size=1920,1200");
            return new ChromeDriver(options);
        }
    },

    FIREFOX {
        @Override
        public WebDriver getDriver() {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    },

    EDGE {
        @Override
        public WebDriver getDriver() {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("mac")) {
                System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/drivers/mac/msedgedriver");
            }
            return new EdgeDriver();
        }
    },

    SAFARI {
        @Override
        public WebDriver getDriver() {
            return new SafariDriver();
        }
    },

}
