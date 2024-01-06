package integration.factory.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id= "user-name")
    private WebElement usernameInput;

    @FindBy(id= "password")
    private WebElement passwordInput;

    @FindBy(id= "login-button")
    private WebElement loginButton;


    public WebElement getUsernameInput(){
        return usernameInput;
    }
    public WebElement getPasswordInput(){
        return passwordInput;
    }
    public WebElement getLoginButton(){
        return loginButton;
    }

}