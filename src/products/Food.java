package products;

 /**
 * A Class for Food product type  
 * @author Omar
 */
public class Food extends Products {
/**
 * A Food constructor to set info values about food product 
 */
    public Food() {
        this.productType = "Food";
        this.productPrice = 45;
        this.productCode = 1;
        this.productsMaplist.put(productCode, productPrice);
        displayProductInfo();
    }
/**
 * An implementation of abstract method at Product class
 * to prepare a product for delivery
 */
    public void prepareProduct() {
        this.readyToUseProdMessage = "Your Food is ready to eat!";

    }

}
