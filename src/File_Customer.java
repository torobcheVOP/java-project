import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class File_Customer {
ArrayList<String> arrayList_Customer=new ArrayList<>();
    public void Creating_File(String name, int National_Id, int Phone, String address,boolean g) {
        try {
            File Customer_File = new File("C:\\Data\\Customer.txt");
            if (Customer_File.createNewFile()) {
                System.out.println("File created: " + Customer_File.getName());
                Writing_File(name, National_Id, Phone, address, g);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
        public void Reading_File (String name,int National_Id, int Phone, String address,boolean g)
        {
File Customer_File=new File("C:\\Data\\Customer.txt");
if(Customer_File.exists())
{
    try
{
    Scanner Reading=new Scanner(Customer_File);
while (Reading.hasNextLine())
{
    String line =Reading.nextLine();
    if(!line.contains(String.valueOf(National_Id)))
    {
        g=true;
    }
    else {
        g=false;
        break;
    }
}
Writing_File(name, National_Id,  Phone,  address, g);
}
catch (IOException i)
{

}
}
else
{
 Creating_File(name,National_Id,Phone,address,g);
}
        }

        public void Writing_File (String name,int National_Id, int Phone, String address,boolean g)
        {
            try
            {
                if(g==true)
                {
                    File Customer =new File("C:\\Data\\Customer.txt");
                    FileWriter Customer_File=new FileWriter("C:\\Data\\Customer.txt",true);
                    Customer_File.write("NEW customer: "+"\t");
                    Customer_File.write("Name : "+name+"\t");
                    Customer_File.write("National id: "+National_Id+"\t");
                    Customer_File.write("Phone: "+Phone+"\t");
                    Customer_File.write("Address: "+address+"\n");

                    Customer_File.flush();
                    Customer_File.close();
                    System.out.println("FIle wrote successfully");
                }
                else
                {
                    System.out.println("the Customer already inserted in the file");
                }

            }
            catch (IOException io)
            {
                System.out.println("An error occurred.");
                io.printStackTrace();
            }
        }
        public void Removing_file(int National_id)
        {
            try
            {
                File file=new File("C:\\Data\\Customer.txt");

                    Scanner Reading_file=new Scanner(file);
                    Scanner scanner=new Scanner(System.in);
                    String value;
                    String currentline;
                    ArrayList<String> arrayList=new ArrayList<>();

               while (Reading_file.hasNextLine())
               {
                   String line =Reading_file.nextLine();
                   if(!line.contains(String.valueOf(National_id)))
                   {
                       arrayList.add(line);
                   }
                   else {
                       continue;
                   }

               }
                Reading_file.close();
               if(file.delete())
               {
                   System.out.println(file.getName()+"delete");
                   File newfile=new File("C:\\Data\\Customer.txt");
                   FileWriter fileWriter=new FileWriter(newfile,true);
                   for(int i=0;i<arrayList.size();i++)
                   {
                       fileWriter.write(arrayList.get(i));
fileWriter.write("\n");
                   }
                   fileWriter.close();
                   for(int i=0;i<arrayList.size();i++)
                   {
                       System.out.println(arrayList.get(i));

                   }
               }
               else
               {
                   System.out.println("file exist");
               }


            }
            catch (IOException io)
            {

            }
        }
    }

