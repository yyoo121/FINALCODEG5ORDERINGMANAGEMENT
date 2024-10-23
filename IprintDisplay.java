import java.util.LinkedList;

public interface IprintDisplay {
    public void welcome();
    public void printMenu(Order menu);
    public void printAddedItem(Item item);
    public void printSelectedItems(LinkedList<Item> items);
    public void printInvalidInput();
    public void printInsufficientFunds();
    public void printExitingCheckout();
    public void printExit();
    public void printItemRemoved();
    public void printItemUpdated();
    public void printNewCartCreated();
    public void printTotalBill(double totalPrice);
    
}
