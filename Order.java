import java.util.LinkedList;
public class Order{
    protected LinkedList<Item> items;
    private String delicateness;
    private String cleaningPreference;
    
    public Order(){items = new LinkedList<>();}

    public void add(String item, double price, int quantity){
        items.add(new Item(item, price, quantity));}

    public String getItem(int x){return items.get(x).getName();}

    public double getPrice(int x){return items.get(x).getTotalPrice();}

    public int getTotalItems(){return items.size();}

    public double getTotalOrderPrice(){
    double total = 0;
    for (Item item : items)
    {total += item.getTotalPrice();
        }return total;}

    public String getDelicateness() {return delicateness;}
    public void setDelicateness(String delicateness) {this.delicateness = delicateness;}

    public String getCleaningPreference() {return cleaningPreference;}
    public void setCleaningPreference(String cleaningPreference){this.cleaningPreference = cleaningPreference;}}