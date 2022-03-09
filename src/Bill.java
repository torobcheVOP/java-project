import java.io.File;
import java.util.Date;

public class Bill {
public static Person person;
    public static Customer customer ;
    public static Product product;
    public static String Date;
    public static int Nums;
File_Bill file_bill=new File_Bill();
    public Bill(Person person,Customer customer,Product product,String date,int Nums)
    {
        this.person=person;
        this.customer=customer;
        this.Date= date;
        this.Nums=Nums;
        this.product=product;
        file_bill.Reading_File(customer,product,Date,Nums);
    }
    public Bill()
    {

    }
    //methods

    public void Save(Customer customer,Product product,String Date,int Nums)
    {
File_Bill file_bill=new File_Bill();
file_bill.Reading_File(customer,product,Date, Nums);
    }
    public void Remove(int National_id,String model)
    {
File_Bill file_bill=new File_Bill();
file_bill.Removing_file(National_id,model);
    }
}
