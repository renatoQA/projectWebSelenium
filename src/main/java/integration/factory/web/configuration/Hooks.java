package integration.factory.web.configuration;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import integration.factory.web.common.BaseTest;
import integration.factory.web.enums.Web;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks extends BaseTest {

    /*
    Method before test to set up the browser , if you wants to test in other browser only need to change the property
    Web."browser" (FIREFOX,EDGE,CHROME)
     */
    @Before
    public void beforeTest() throws MalformedURLException {
        System.out.println("Operational System: " + System.getProperty("os.name"));
        super.inicializeDriver(Web.FIREFOX);

    }
     /*
     Method after concluse test to screenshot a evidence and quit de driver.
      */
    @After
    public void afterTest(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        String directoryPath = "target/screenshots";

        // Generate a unique file name based on the timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
        String fileName = "screenshot_" + timestamp + ".png";
        String filePath = directoryPath + "/" + fileName;

        // Save the screenshot as a file
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        attachScreenshotToAllure(screenshot, scenario.getName());
        driver.quit();
    }
    /*
      Method to attach screenshot to Allure
     */
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshotToAllure(byte[] screenshot, String stepName) {
        Allure.addAttachment(stepName, new ByteArrayInputStream(screenshot));
        return screenshot;
    }
}
