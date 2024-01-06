package integration.factory.funcs;


import integration.factory.pages.CheckoutPage;
import integration.factory.web.common.BaseTest;



public class CheckoutFunc extends BaseTest {

    CheckoutPage checkoutPage = new CheckoutPage(driver);


    /*
    Method to fill the forms in checkout page using the data from config.properties
     */
    public void formsCheckout(String FirstName, String LastName, String ZipCode) {
        checkoutPage.getFirstNameInput().sendKeys(readProperties("config", FirstName));
        checkoutPage.getLastNameInput().sendKeys(readProperties("config", LastName));
        checkoutPage.getZipCodeInput().sendKeys(readProperties("config", ZipCode));
        checkoutPage.getContinueButton().click();
    }

    /*
    Method to finish the checkout flow and validate if return was expected
     */
    public boolean finishCheckout() {
        if (checkoutPage.getTotalLabel().isDisplayed()) {
            checkoutPage.getFinishButton().click();
            return checkoutPage.getSuccessMessageLabel().getText().equals("Your order has been dispatched, and will arrive just as fast as the pony can get there!");
        }
        return false;
    }


}