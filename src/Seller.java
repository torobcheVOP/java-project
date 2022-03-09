import sun.security.util.Password;

import java.io.File;

public class Seller extends Person {


    public Seller(String name,int national_Id)
    {
        super(name,national_Id);
    }
    //methods
public Seller()
{

}


    public void Save(String User,int Pass)
    {
        File_Seller file_seller=new File_Seller();
        file_seller.Reading_File(User,Pass);
    }

    public void Remove(String User,int Pass)
    {
File_Seller file_seller=new File_Seller();
file_seller.Removing_file(User, Pass);
    }
}
