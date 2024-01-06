package integration.factory.funcs;


import integration.factory.pages.ProductPage;
import integration.factory.web.common.BaseTest;

public class ProductFunc extends BaseTest {

    ProductPage productPage = new ProductPage(driver);

    /*
    Method to validate if login is ok or have any error
     */
    public boolean validateLogin(){
       if(productPage.getInventoryLabel().isEnabled()){
           return true;
       }else{
           System.out.println("Error to realize login!!!");
           return false;
       }
    }
    /*
    Using that function to filter the product by type of price (cheapest or expensive)
     */
    public void filterPrice(String filter){
        productPage.getFilterGeneral().isEnabled();
        productPage.getFilterGeneral().click();
        if(filter.equals("cheapest")){
            productPage.getFilterLowtoHigh().isEnabled();
            productPage.getFilterLowtoHigh().click();
        }else{
            productPage.getFilterHighToLow().isEnabled();
            productPage.getFilterHighToLow().click();
        }
    }
    public void addFirstToCard(){
        productPage.getFirstAddCartButton().click();
        productPage.getCartIconButton().click();
    }
}
