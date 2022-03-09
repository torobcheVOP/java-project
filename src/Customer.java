public class Customer extends Person {
    private int Phone;
    private String address;
    public Customer(String name,int National_id,int Phone,String address)
    {
        super(name,National_id);
        this.Phone=Phone;
        this.address=address;
    }
    public Customer()
    {

    }//methods


    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void Save(String Customer_name,int National_id,int Phone,String address,boolean g)
    {
File_Customer file_customer=new File_Customer();
file_customer.Reading_File(Customer_name,National_id,Phone,address,g);
    }
    public void Remove(int National_id)
    {
File_Customer file_customer=new File_Customer();
file_customer.Removing_file( National_id);
    }
}
