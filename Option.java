import java.util.InputMismatchException;

public class Option implements IOption {
    private Carts cart;
    private Inputter io;
    private Displayer display;
    private DisplayReceipt RecDis;

    public Option(Carts cart, Inputter io, Displayer display, DisplayReceipt RecDis) {
        this.cart = cart;
        this.io = io;
        this.display = display;
        this.RecDis = RecDis;
    }
    @Override
    public void itemAdder(Order menu) {
        display.printMenu(menu);
        processItemSelection(() -> {
            int n = io.getItemIndex(menu);
            if (passs(n, menu.getTotalItems())) {
                Item item = new Item(menu.getItem(n - 1), menu.getPrice(n - 1), 1);
                cart.addItem(item);
                display.printAddedItem(item);
                display.printSelectedItems(cart.getItemList());
            } else { display.printInvalidInput();}});}

    @Override
    public void itemRemover(){
        processItemSelection(() ->{
            int x = io.getRemovalIndex();
            if (passs(x, cart.getItemList().size())) {
                cart.removeItem(x - 1);
                display.printItemRemoved();
            } else display.printInvalidInput();});}

    @Override
    public void itemUpdater() {
        processItemSelection(() -> {
            int x = io.getUpdateIndex();
            if (passs(x, cart.getItemList().size())) {
                cart.updateItem(x - 1, io.getNewQuantity());
                display.printItemUpdated();
            } else display.printInvalidInput();});
    }
    @Override
    public void createNewCart() {cart = new Carts(); display.printNewCartCreated(); }

    @Override
    public void checkout() {
        display.printSelectedItems(cart.getItemList());
        double totalPrice = cart.getTotalPrice();
        display.printTotalBill(totalPrice);
        processPayment(totalPrice);
    }
    private void processPayment(double totalPrice) {
        while (true) {
            try {
                double money = io.getPayment();
                if (money < 0) {display.printExitingCheckout();return;}
                if (money < totalPrice) {display.printInsufficientFunds();
                } else {completeCheckout(money, totalPrice);break;}
            } catch(InputMismatchException e){
                display.printInvalidInput();io.clear();
            }}}
    private void completeCheckout(double money, double totalPrice){
        RecDis.topreceipt();
        RecDis.contactreceipt();
        RecDis.printiteminforeceipt(cart.getItemList(), money, totalPrice, money - totalPrice);
        aftercheckout();
    }
    private void aftercheckout() {
        int choice = io.getChoice();
        if (choice == 1) orderAgain();
        else if (choice == 2) System.exit(0); 
        else display.printInvalidInput();}

    @Override
    public void orderAgain(){ cart = new Carts();}
    private boolean passs(int x, int size) { return x > 0 && x <= size;}
    private void processItemSelection(Runnable run) {run.run();}}
