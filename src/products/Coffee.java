package products;

/**
 * A Class for coffee product type
 *
 * @author Omar
 */
public class Coffee extends Products {

    /**
     * A Coffee constructor to set info values about coffee product
     */
    public Coffee() {
        this.productType = "Coffee";
        this.productPrice = 8;
        this.productCode = 2;
        this.productsMaplist.put(productCode, productPrice);
        displayProductInfo();
    }

    /**
     * An implementation of abstract method at Product class to prepare a
     * product for delivery
     *
     */
    public void prepareProduct() {

        this.readyToUseProdMessage = "Your Coffee is ready to drink!";

    }

}
