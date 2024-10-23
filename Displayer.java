import java.util.LinkedList;
public class Displayer implements IprintDisplay{
    @Override
    public void welcome(){
        System.out.println("Welcome to Cyber Grab Ordering Application");
    }
    @Override
    public void printMenu(Order menu) {
    System.out.println("------------------------------------------------------------");
    System.out.println("\tMenu");
        for (int x = 0; x < menu.getTotalItems(); x++){
            System.out.println("["+(x + 1)+ "] " +menu.getItem(x)+" --- P "+menu.getPrice(x));
    }
    System.out.println("------------------------------------------------------------");
    }
    @Override
    public void printAddedItem(Item item){System.out.println("\nYou added: "+item.getName()+" --- P "+item.getPrice());
    }
    @Override
    public void printSelectedItems(LinkedList<Item> items){ System.out.println("\nYou selected the following items: ");

                for (int x = 0; x < items.size(); x++)
                {System.out.println("["+(x + 1)  +
                "] " + items.get(x).getName()+
                " --- Quantity: "+items.get(x).getQuantity()+
                " --- Price: "+items.get(x).getTotalPrice());
                }}
    @Override
    public void printInvalidInput(){
        System.out.println("Invalid input.");}
    @Override
    public void printInsufficientFunds(){
        System.out.println("You don't have enough money. Please try again.");}
    @Override
    public void printExitingCheckout(){
        System.out.println("Exiting checkout...");}
    @Override
    public void printExit(){
        System.out.println("exit");}
    @Override
    public void printItemRemoved(){
        System.out.println("Item is removed!");}
    @Override
    public void printItemUpdated(){
        System.out.println("Item has Changed Quantity!");}
    @Override
    public void printNewCartCreated(){
        System.out.println("Resetting the cart!");}
    @Override
    public void printTotalBill(double totalPrice){
        System.out.println("Your total bill is: "+totalPrice);}
        
    }
