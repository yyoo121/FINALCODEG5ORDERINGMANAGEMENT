import java.io.*;
import java.util.LinkedList;
public class Receipttxt {

    private static final String DOWNLOADS_FOLDER = System.getProperty("user.home") + "/Downloads/";

    public void saveReceipt(LinkedList<Item> items, double money, double totalPrice, double change, Contact info){

        String fileName = DOWNLOADS_FOLDER + "receipt_" + System.currentTimeMillis() + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            
            writer.write("----------------------------------------------------\n");
            writer.write("     Cyber Grab Ordering Application     \n");
            writer.write("              Receipt:                 \n");
            writer.write("Customer name             : " + info.getUserName() + "\n");
            writer.write("Customer No#              : " + info.getContactNumber() + "\n");
            writer.write("Customer Email            : " + info.getEmail() + "\n");
            writer.write("Customer Delivery Address : " + info.getDeliveryAddress() + "\n\n");
            writer.write("ITEMS:\n");

            for (int x = 0; x < items.size(); x++) {
                writer.write("[" + (x + 1) + "] " + items.get(x).getName() +
                        " --- Quantity: " + items.get(x).getQuantity() +
                        " --- Price: " + items.get(x).getTotalPrice() + "\n");
            }
            writer.write("\nMoney: " + money + "\n");
            writer.write("Total: " + totalPrice + "\n");
            writer.write("Change: " + change + "\n");

            DeliveryTime dt = new DeliveryTime();
            String deliveryTime = dt.getRandomDeliveryTime();

            writer.write(deliveryTime + "\n");
            writer.write("Thank you for Ordering at Cyber Grab\n");
            writer.write("---------------------------------------------------\n");
            System.out.println("Receipt saved to: " + fileName);
        } catch (IOException e) {System.out.println("Error writing to file: " + e.getMessage());}}}
