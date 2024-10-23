public class Contact{
    private String Username;
    private String contactNumber;
    private String email;
    private String deliveryAddress;

    public Contact(String Username, String contactNumber, String email, String deliveryAddress){
        this.Username = Username;
        this.contactNumber = contactNumber;
        this.email = email;
        this.deliveryAddress = deliveryAddress;
    }
    public String getUserName(){return Username;}
    public String getContactNumber(){return contactNumber;}
    public String getEmail(){return email;}
    public String getDeliveryAddress(){return deliveryAddress;}}

