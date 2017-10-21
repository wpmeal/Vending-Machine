package machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import products.Products;



/**
 * VendingMachine Class receive and validate user inputs i.e  money and chosed products then return 
 * a list of chosed products if user has enough money for each one.
 * @author Omar 
 */
public class VendingMachine {

    private int moneyPool; 
    private static Scanner captureUsrInput = new Scanner(System.in);
    private static int moneyChange;
    private boolean finishPayment;
    private static List<Integer> moneyDenominations = new ArrayList();
    private String errorMessage;
    private boolean usrInptResult;
    private int totalPayTries = 5;
    private Map<Integer, Integer> productsMaplist = Products.getProductsMaplist();
    private List<Integer> orderList = new ArrayList();

    static {
        moneyDenominations.add(1);
        moneyDenominations.add(5);
        moneyDenominations.add(20);
        moneyDenominations.add(50);
        moneyDenominations.add(100);
        moneyDenominations.add(500);
        moneyDenominations.add(1000);

    }
    private boolean OrderInptResult;
    private boolean finishOrder;

    /**
     * Dislay a Message for receiveing money from user
     */
    public void collectMoneyMessage() {
        System.out.println("Please enter one or more of the following Money Denominations as numbers then press '0' to finish payment and continue");
        Iterator itr = moneyDenominations.iterator();

        while (itr.hasNext()) {
            System.out.print(itr.next() + " | ");
        }

        System.out.println();
    }

    /**
     * Capture user input
     *
     * @param usrCmdMessage custom message before receiving inputs
     * @return user input as int value
     */
    public int takeUsrInput(String usrCmdMessage) {
        System.out.println(usrCmdMessage);
        usrInptResult = false;
        int usrInpt = 0;
        try {
            usrInpt = captureUsrInput.nextInt();

            usrInptResult = true;
        } catch (Exception e) {
            errorMessage = "Wrong Input! U should enter integer values.";
            System.out.println(errorMessage);
            usrInptResult = false;
            captureUsrInput.nextLine();

        }
        return usrInpt;
    }

    /**
     * Test user input if it meets required money denomination list
     *
     * @param money money user input
     * @return boolean
     */
    public boolean checkMoneyDenomination(int money) {
        finishPayment = false;
        if (moneyDenominations.contains(money)) { // check if money value exits in money denomination list
            usrInptResult = true;
        } else if (money == 0) { // stop payment command from user
            finishPayment = true;
            usrInptResult = true;
        } else {

            usrInptResult = false;
            errorMessage = "Wrong Input! U should enter money from money denominations that mentioned above.";
            System.out.println(errorMessage);

        }
        return usrInptResult;
    }

    /**
     * Iterate receiving money user input
     */
    public void takePaymentItr() {
        int money = 0;
        collectMoneyMessage();
        do {
            money = takeUsrInput("Enter Money:");
            if (usrInptResult == true) {
                if (checkMoneyDenomination(money) == true) {
                    moneyChange += money;
                }
            }

        } while ((usrInptResult != true) || (finishPayment != true));

    }

    

    /**
     * Iterate receiving user order inputs
     */
    public void takeOrdersItr() {
        int prodCode = 0;
        boolean stopOrdersItr = false;
        do {
            prodCode = takeUsrInput("Enter Product Code to Purchase or `0` to continue.");
            stopOrdersItr = (prodCode == 0) ? true : false;
            if (usrInptResult == true && prodCode != 0) {
                if (productsMaplist.containsKey(prodCode) == true) { // only accept product code that exists as one of products codes
                    int prodPrice = productsMaplist.get(prodCode);
                    if (hasEnoughMoney(prodPrice) == true) { //add product code to order list thers 's enough money
                        orderList.add(prodCode);
                    } else {
                        System.out.println("Error! Please enter enough money then try again.");
                        takePaymentItr();
                    }
                } else {
                    System.out.println("Bad Products Codes !");
                    stopOrdersItr = true;
                }
            }

        } while ((usrInptResult != true) || (stopOrdersItr != true));
        usrInptResult = false;
    }

    /**
     * Check if user has enough money to buy specific product
     *
     * @param prodPrice product code to be purchased
     * @return order list contains all ordered products
     */
    public boolean hasEnoughMoney(int prodPrice) {

        boolean result = (moneyChange >= prodPrice) ? true : false;
        
        if(result == true)  moneyChange -=prodPrice ; 

        return result;
    }
    
    /**
     * Return list of products codes for ordered products
     *
     * @return
     */
    public List<Integer> getOrderList() {
        return orderList;
    }
    public static int getMoneyChange(){
        return moneyChange;
    }
}
