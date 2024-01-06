package integration.factory.funcs;

import integration.factory.pages.CartPage;
import integration.factory.web.common.BaseTest;

import org.junit.Assert;


public class CartFunc extends BaseTest {

    CartPage cartPage = new CartPage(driver);


    /*
    Method to validate in checkout if is ok to advance from the next step from checkout (if have itens or not in the cart)
     */
    public void advanceCheckout(){
        String quantityItem = cartPage.getQtyCart().getText();
        int quantityItemCart = Integer.parseInt(quantityItem);

        if (quantityItemCart > 0) {
            cartPage.getCheckoutButton().isEnabled();
            cartPage.getCheckoutButton().click();
        }else{
            Assert.fail("Dont have itens add in cart");
        }
    }
    /*
    Method to perfome remove itens from a shopping cart
     */
    public void removeItens(){
        cartPage.getRemoveButton().isEnabled();
        cartPage.getRemoveButton().click();
        cartPage.getContinueShoppingButton().click();
    }
}