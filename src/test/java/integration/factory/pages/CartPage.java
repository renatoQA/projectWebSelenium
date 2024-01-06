package integration.factory.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath= "//div[@class='cart_quantity']")
    private WebElement qtyCart;

    @FindBy(xpath="//button[@class='btn btn_secondary btn_small cart_button']")
    private WebElement removeButton;

    @FindBy(id= "checkout")
    private WebElement checkoutButton;

    @FindBy(id= "continue-shopping")
    private WebElement continueShoppingButton;


    public WebElement getQtyCart(){
        return qtyCart;
    }
    public WebElement getRemoveButton(){
        return removeButton;
    }
    public WebElement getCheckoutButton(){
        return checkoutButton;
    }
    public WebElement getContinueShoppingButton(){
        return continueShoppingButton;
    }
}