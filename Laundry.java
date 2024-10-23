public class Laundry extends Order{
    public Laundry(){super();LaundryMenu();}
    private void LaundryMenu(){
        add("5kg laundry", 50, 1);
        add("10kg laundry", 100, 1);
        add("15kg laundry", 150, 1);
        add("20kg laundry", 200, 1);
        add("25kg laundry", 250, 1);
        add("30kg laundry", 300, 1);
        add("35kg laundry", 350, 1);
        add("40kg laundry", 400, 1);
        add("50kg laundry", 450, 1);
        add("60kg laundry", 500, 1);
    }
}