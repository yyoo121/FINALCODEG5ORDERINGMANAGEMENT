import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputter implements IInputter {
    private Scanner sc = new Scanner(System.in);
    private int getinput(String prompt) {
        int input = -1; boolean valid = false;
        while (!valid) {
            try {
                System.out.println(prompt); input = sc.nextInt(); valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");sc.nextLine();
            }}return input;
        }
    @Override
    public int getItemIndex(Order menu) {
        return getinput("Enter the item you want to add [use index]: ");}
    @Override
    public int getRemovalIndex() {
        return getinput("Enter the index of the item you want to remove: ");}
    @Override
    public int getUpdateIndex() {
        return getinput("Enter the index of the item that will update/change quantity: ");}
    @Override
    public int getNewQuantity() {
        return getinput("Type new quantity: ");}
    @Override
    public double getPayment() {
        System.out.println("Enter your money: ");
        return sc.nextDouble(); }
    @Override
    public int getChoice() {
        return getinput("[1] Order again\n[2] Exit now: ");}
    public void clear() {
        if (sc.hasNextLine()) { sc.nextLine();
        }}
    public Contact inputContactInfo() {
        System.out.println("\n[Enter your Delivery Information to successfully order]");
        System.out.println("Enter your name: ");String Username = sc.nextLine();
        System.out.println("Enter your contact number: ");String contactNumber = sc.nextLine();
        System.out.println("Enter your email: ");String email = sc.nextLine();
        System.out.println("Enter your delivery address: ");String deliveryAddress = sc.nextLine();

        return new Contact(Username, contactNumber, email, deliveryAddress);
    }
}
