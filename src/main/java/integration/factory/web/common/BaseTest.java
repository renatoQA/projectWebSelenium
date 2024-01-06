package integration.factory.web.common;

import integration.factory.interfaces.ApplicationWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Properties;

public abstract class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    /*
    Method to start the browser
     */
    protected void inicializeDriver(ApplicationWeb applicationWeb) throws MalformedURLException {
        driver = applicationWeb.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    /*
    Method to read properties or data from files
     */
    public String readProperties(String properties, String info) {
        String contents = null;
        try {
            FileReader reader = new FileReader(System.getProperty("user.dir") + "/src/main/java/integration/factory/web/enums/" + properties + ".properties");
            Properties p = new Properties();
            p.load(reader);
            contents = p.getProperty(info);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return contents;
    }

}
