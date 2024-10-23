import java.util.LinkedList;


public class DisplayReceipt {
    private Contact contact; 
    public void setContact(Contact contact){
        this.contact = contact;
    }
    
   
    public void topreceipt(){
        System.out.println("----------------------------------------------------");
        System.out.println("     Cyber Grab Ordering Application     ");
        System.out.println("              Receipt:                 ");
    }
    public void contactreceipt(){
        System.out.println("Customer name             : "+ contact.getUserName());
        System.out.println("Customer No#              : "+ contact.getContactNumber());
        System.out.println("Customer Email            : "+ contact.getEmail());
        System.out.println("Customer Delivery Address : "+ contact.getDeliveryAddress());
        System.out.println();
    }
    public void printiteminforeceipt(LinkedList<Item> items, double money, double totalPrice, double change){
        System.out.println("ITEMS:");
        for (int x =0;x<items.size();x++) {
            System.out.println("["+(x+1)+"] "+items.get(x).getName()+
                            " --- Quantity: "+items.get(x).getQuantity()+
                            " --- Price: "+items.get(x).getTotalPrice());
                }
            System.out.println("\nMoney: "+money);
            System.out.println("Total: "+totalPrice);
            System.out.println("Change: "+change);
            System.out.println();

            DeliveryTime dt = new DeliveryTime();
            String deliveryTime = dt.getRandomDeliveryTime();
            System.out.println(deliveryTime);
            System.out.println("Thank you for Ordering at Cyber Grab");
            System.out.println("---------------------------------------------------");

            Receipttxt receiptFileHandler = new Receipttxt();
            receiptFileHandler.saveReceipt(items, money, totalPrice, change, contact);
        }
    
}

