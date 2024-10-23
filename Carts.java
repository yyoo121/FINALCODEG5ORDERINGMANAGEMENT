import java.util.LinkedList;
public class Carts{
    private Order currentOrder;
    private LinkedList<Item> itemList;
    public Carts()
    {  this.currentOrder = new Order();
        itemList = new LinkedList<>();}
    public void addItem(Item item){itemList.add(item);}
    public Order getOrder(){return currentOrder;}

    public void removeItem(int x){
        if (x < 0 || x >= itemList.size()){throw new IndexOutOfBoundsException("within the range only");}
        itemList.remove(x);}

    public void updateItem(int x, int newQuantity){
        if (x<0 || x >= itemList.size()){throw new IndexOutOfBoundsException("within of range only");}
        itemList.get(x).setQuantity(newQuantity);}

    public LinkedList<Item> getItemList(){return new LinkedList<>(itemList);}
    
    public double getTotalPrice(){
        double total = 0;
        for(Item item : itemList){
            total += item.getTotalPrice();
        }return total;}}
