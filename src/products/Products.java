package products;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import machine.VendingMachine;

/**
 * A Super abstract Class that has common fields and methods of each product 
 * 
 * @author Omar
 */
public abstract class Products {

    protected boolean readyToUseProduct;
    protected String readyToUseProdMessage;

    protected int productPrice;
    protected String productType;
    protected int productCode;
    protected static String PRODUCT_NAME = "Product Name";
    protected static String PRODUCDUCT_NAME = "Product Name";
    protected static String PRODUCT_PRICE = "Product Price";
    protected static String PRODUCT_CODE = "ENTER FOLLOWING CODE TO GET IT.";
    protected static String FINISHORDER_MESSAGE = " PRESS `0` TO FINISH ORDERING.";

    private boolean OrderInptResult;
    protected static Map<Integer, Integer> productsMaplist = new HashMap<>();
    private boolean finishOrder;
    private static int moneyChange;
/**
 * print a product info
 */
    public void displayProductInfo() {
        System.out.println(PRODUCT_NAME + ": " + productType + "\t" + PRODUCT_PRICE + ": " + productPrice + "\t" + PRODUCT_CODE + ": " + productCode + "\t" + FINISHORDER_MESSAGE);
    }


/**
 * print a ready to use message for ordered product
 */
    public void use() {
        System.out.println(readyToUseProdMessage);
    }
/**
 * Return a list of all available products as productCode/productPrice as key/value
 * @return 
 */
    public static Map<Integer, Integer> getProductsMaplist() {
        return productsMaplist;
    }

 
/**
 * Print the remaining amount of money after all ordered have been handled
 */
   
    public static void displayMoneyChange() {
        System.out.println("Here's the rest of ur money: " + VendingMachine.getMoneyChange());

    }
/**
 * return product code as int value
 * @return 
 */
   final public int getproductCode() {
         return productCode;
    }
/**
 * To be implemented by each existed product class to prepare an ordered product for delivery 
 */
   public abstract  void prepareProduct();
    
    
}
