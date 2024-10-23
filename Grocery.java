public class Grocery extends Order {
    public Grocery(){ super();GroceryMenu(); }
    private void GroceryMenu(){
        add("Rice", 50, 1);
        add("Eggs", 8, 1);
        add("Milk", 90, 1);
        add("Soy Sauce", 100, 1);
        add("Vinegar", 80, 1);
        add("Pork Meat", 500, 1);
        add("Chicken Meat", 400, 1);
        add("Flour", 100, 1);
        add("Pepper", 200, 1);
        add("Paprika", 200, 1);
    }
   }