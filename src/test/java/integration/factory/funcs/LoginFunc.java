package integration.factory.funcs;

import integration.factory.pages.LoginPage;
import integration.factory.web.common.BaseTest;

import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.URL;

public class LoginFunc extends BaseTest {

    LoginPage loginPage = new LoginPage(driver);

    /*
    Method to get the Url to access
     */
    public void accessUrl(String Url){
        driver.get(readProperties("config", Url));
    }

    /*
    Method to perform the login with username and password on config.properties
     */
        public void realizeLogin(String Username,String Password){
            loginPage.getUsernameInput().sendKeys(readProperties("config", Username));
            loginPage.getPasswordInput().sendKeys(readProperties("config", Password));
            loginPage.getLoginButton().click();
        }
}