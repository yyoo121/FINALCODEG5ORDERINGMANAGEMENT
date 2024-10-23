import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderManager {
    PreferenceInputter pr = new PreferenceInputter();
    Inputter inputter = new Inputter();
    DisplayReceipt dr = new DisplayReceipt();
    private Scanner scanner;
    private Option shoppingCart;
    private Order menu;

    public OrderManager(Scanner scanner, Option shoppingCart) {
        this.scanner = scanner;
        this.shoppingCart = shoppingCart;
    }
    public void run() { selectOrderType();
        while (true) {
            int choice = getUserChoice(); handleUserChoice(choice);
        }}
    private int getValidInput(String prompt) {
        int input = -1; boolean valid = false;
        while (!valid) {
            try {
                System.out.print(prompt);input = scanner.nextInt();valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number."); scanner.nextLine(); 
            }} return input; }

    private void selectOrderType() {
        boolean valid = false;
        while (!valid) {
            int orderType = getValidInput("Choose order type: [1] Food [2] Flower [3] Grocery [4] Laundry\nEnter order type: ");
            switch (orderType) {
                case 1:menu = new Food();valid = true;break;
                case 2:menu = new Flower();pr.inputdelicateness(menu);valid = true;break;
                case 3:menu = new Grocery();pr.inputdelicateness(menu);valid = true;break;
                case 4:menu = new Laundry();pr.inputcleanpreference(menu);valid = true;break;
                default:
                    System.out.println("Invalid Input! Please enter a valid number within the range!");break;
            }}
        System.out.println("Order Type: " + menu.getClass().getSimpleName());
        if (menu == null){
            System.out.println(" ");
        }else{
            String ccpp = menu.getCleaningPreference();
            String ggdd = menu.getDelicateness();
        System.out.println(ccpp!= null ?ccpp : " ");
        System.out.println(ggdd!= null ?ggdd : " ");}
    }
    
    private int getUserChoice() {
        return getValidInput("\n\tSelect an option:\n" +
                             "[1] Add item to cart [pops menu]\n" +
                             "[2] Remove item from cart\n" +
                             "[3] Update item quantity\n" +
                             "[4] Create a new cart\n" +
                             "[5] Checkout\n" +
                             "[6] Exit\n" +
                             "Enter your choice: ");
    }
    private void handleUserChoice(int choice) {
        switch (choice) {
            case 1:shoppingCart.itemAdder(menu);break;
            case 2:shoppingCart.itemRemover();break;
            case 3:shoppingCart.itemUpdater();break;
            case 4:shoppingCart.createNewCart();break;
            case 5:shoppingCart.checkout();break;
            case 6:System.out.println("Exiting");System.exit(0);break;
            default:System.out.println("Invalid option. Please try again.");break;
        }
    }}
