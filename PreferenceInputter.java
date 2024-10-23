import java.util.InputMismatchException;
import java.util.Scanner;

public class PreferenceInputter {
    Scanner sc = new Scanner(System.in);

    public void inputcleanpreference(Order ord) {
        String[] opt = {"heavy wash", "regular wash", "eco wash", "steam wash"};

        int choice = getUserChoice("Choose cleaning preference: ", opt);
        if (choice >= 0) ord.setCleaningPreference("cleaning preference: " + opt[choice]);
         else ord.setCleaningPreference("cleaning preference: regular wash");}

    public void inputdelicateness(Order ord) {
        String[] opt = {"super delicate", "delicate", "normal"};
        int choice = getUserChoice("Choose delicateness: ", opt);
        if (choice >= 0) ord.setDelicateness("delicateness: " + opt[choice]);
        else System.out.println("Invalid Input.");}

    private int getUserChoice(String m, String[] opt) {
        System.out.println(m);
        for (int i = 0; i < opt.length; i++) {
            System.out.println("[" + (i + 1) + "] " + opt[i]);
        }
        System.out.print("Input your choice: ");
        int choice = -1;  boolean valid = false;

        while (!valid) {
            try {
                choice = sc.nextInt() - 1; 
                if (choice >= 0 && choice < opt.length) {
                    valid = true; 
                } else System.out.println("choose only number between 1 and " + opt.length + ".");
                
            } catch (InputMismatchException e) { System.out.println("number only"); sc.nextLine(); 
            } } return choice;} }
