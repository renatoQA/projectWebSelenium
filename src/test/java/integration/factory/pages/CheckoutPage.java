package integration.factory.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id= "first-name")
    private WebElement firstNameInput;

    @FindBy(id= "last-name")
    private WebElement lastNameInput;

    @FindBy(id= "postal-code")
    private WebElement zipCodeInput;

    @FindBy(id= "continue")
    private WebElement continueButton;


    @FindBy(xpath= "//div[contains(text(), 'Total:')]")
    private WebElement totalLabel;

    @FindBy(id= "finish")
    private WebElement finishButton;

    @FindBy(xpath= "//div[@class='complete-text']")
    private WebElement successMessageLabel;

    public WebElement getFirstNameInput(){
        return firstNameInput;
    }
    public WebElement getLastNameInput(){
        return lastNameInput;
    }
    public WebElement getZipCodeInput(){
        return zipCodeInput;
    }
    public WebElement getContinueButton(){
        return continueButton;
    }


    public WebElement getTotalLabel(){
        return totalLabel;
    }
    public WebElement getFinishButton(){
        return finishButton;
    }

    public WebElement getSuccessMessageLabel(){
        return successMessageLabel;
    }
}