package integration.factory.pages;


import integration.factory.web.enums.Web;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inventory_container")
    private WebElement inventoryLabel;

    @FindBy(xpath = "//*[@id='header_container']//select")
    private WebElement filterGeneral;

    @FindBy(xpath = "//*[@id='header_container']//select/option[3]")
    private WebElement filterLowToHigh;

    @FindBy(xpath = "//option[@value='hilo']")
    private WebElement filterHighToLow;

    @FindBy(xpath = "//button[contains(@class, 'btn_inventory')]")
    private WebElement firstAddCartButton;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartIconButton;

    public WebElement getInventoryLabel(){
        return inventoryLabel;
    }
    public WebElement getFilterGeneral(){
        return filterGeneral;
    }
    public WebElement getFilterLowtoHigh(){
        return filterLowToHigh;
    }
    public WebElement getFilterHighToLow(){
        return filterHighToLow;
    }
    public WebElement getFirstAddCartButton(){
        return firstAddCartButton;
    }
    public WebElement getCartIconButton(){
        return cartIconButton;
    }
}