package products;

/**
 * A Class for snacks product type
 * @author Omar
 */
public class Snacks extends Products {
/**
 * A Snacks constructor to set info values about snacks product 
 */
    public Snacks() {
        this.productType = "Snacks";
        this.productPrice = 50;
        this.productCode = 3;
        this.productsMaplist.put(productCode, productPrice);
        displayProductInfo();
    }
/**
 * An implementation of abstract method at Product class
 * to prepare a product for delivery
 */
    public void prepareProduct() {

        this.readyToUseProdMessage = "Your Snacks is ready to eat!";

    }

}
