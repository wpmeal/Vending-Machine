/**
 * Vending Machine Project
 * Developed By Omar Mahrous
 * 26-09-2017
 */
import java.util.Iterator;
import machine.VendingMachine;
import products.Coffee;
import products.Food;
import products.Products;
import products.Snacks;

/**
 * A Main Class to initialize Vending Machine project
 *
 * @author Omar
 */
public class Main {

    public static void main(String args[]) {
        System.out.println("*********** Welcome To Vending Machine Created By Omar Mahrous **************\n");
        
        System.out.println("List of available products :");

        Products food = new Food();

        Products coffee = new Coffee();

        Products snacks = new Snacks();

        System.out.println();
        
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.takePaymentItr();

        vendingMachine.takeOrdersItr();

        int orderNum = 1;
        for (Integer prodCode : vendingMachine.getOrderList()) { // Iterate ordered products list to fetch products codes 
            System.out.println("*********** Order Number#" + orderNum + "**************");

            if (prodCode == food.getproductCode()) {
                food.prepareProduct();
                food.use();
            } else if (prodCode == coffee.getproductCode()) {
                coffee.prepareProduct();
                coffee.use();
            } else if (prodCode == snacks.getproductCode()) {
                snacks.prepareProduct();
                snacks.use();
            }
            orderNum++;
        }
        Products.displayMoneyChange();

    }
}
