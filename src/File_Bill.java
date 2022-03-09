import sun.security.util.CurveDB;

import javax.jws.WebParam;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class File_Bill {

    public void Reading_File(Customer customer,Product product,String Date,int Nums)
    {
        File Bill_File=new File("C:\\Data\\Bill.txt");
        if(Bill_File.exists())
        {
            Writing_File( customer, product, Date, Nums);
        }
        else
        {
            Creating_File( customer, product, Date, Nums);
        }
    }

    public void Creating_File(Customer customer,Product product,String Date,int Nums)
    {
        try {
            File Bill_File = new File("C:\\Data\\Bill.txt");
            if (Bill_File.createNewFile()) {
                System.out.println("File created: " + Bill_File.getName());
                Writing_File( customer, product, Date, Nums);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void Writing_File(Customer customer,Product product,String Date,int Nums)
    {
        Person person=new Person();
        person.setName(customer.getName());
        person.setNational_Id(customer.getNational_Id());
        try
        {
            File Bill =new File("C:\\Data\\Bill.txt");
            FileWriter Bill_File=new FileWriter("C:\\Data\\Bill.txt",true);
            Bill_File.write("customer info"+"\t");
            Bill_File.write("Name : "+person.getName()+"\t");
            Bill_File.write("National id: "+person.getNational_Id()+"\t");
            Bill_File.write("Phone: "+customer.getPhone()+"\t");
            Bill_File.write("Address: "+customer.getAddress()+"\t");

            Bill_File.write("Product info"+"\t");
            Bill_File.write("Name: "+product.getName()+"\t");
            Bill_File.write("Company: "+product.getCompany()+"\t");
            Bill_File.write("Model: "+product.getModel()+"\t");

            Bill_File.write("Date: "+Date+"\t");
            Bill_File.write("Amount: "+Nums+"\t");
            Bill_File.write("\n");

            Bill_File.flush();
            Bill_File.close();
            System.out.println("FIle wrote successfully");
        }
        catch (IOException io)
        {
            System.out.println("An error occurred.");
            io.printStackTrace();
        }
    }
    public void Removing_file(int National_id,String Model)
    {
        try
        {
            File file=new File("C:\\Data\\Bill.txt");

            Scanner Reading_file=new Scanner(file);
            Scanner scanner=new Scanner(System.in);
            String value;
            String currentline;
            ArrayList<String> arrayList=new ArrayList<>();

            while (Reading_file.hasNextLine())
            {
                String line =Reading_file.nextLine();
                if(!line.contains(String.valueOf(National_id))&&!line.contains(Model))
                {
                    arrayList.add(line);
                }

            }
            Reading_file.close();
            if(file.delete())
            {
                System.out.println(file.getName()+"delete");
                File newfile=new File("C:\\Data\\Bill.txt");
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
