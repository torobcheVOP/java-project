import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.Scanner;

public class File_Product {
    public void File_writer(String name,String Company,String model,boolean f)
    {
        try
        {
            if(f==true)
            {
                File Customer =new File("C:\\Data\\Product.txt");
                FileWriter Customer_File=new FileWriter("C:\\Data\\Product.txt",true);
                Customer_File.write("NEW Product"+"\t");
                Customer_File.write("Name :"+name+"\t");
                Customer_File.write("Model: "+Company+"\t");
                Customer_File.write("Model: "+model+"\t");
                Customer_File.write("\n");
                Customer_File.flush();
                Customer_File.close();
                System.out.println("FIle wrote successfully");
            }
            else
            {
                System.out.println("the product already inserted in the file;");
            }

        }
        catch (IOException io)
        {
            System.out.println("An error occurred.");
            io.printStackTrace();
        }
    }

    public void File_Reader(String name,String Company,String model,boolean f)
    {
        File Product_File=new File("C:\\Data\\Product.txt");
        if(Product_File.exists())
        {
            try
            {
                Scanner Reading_file=new Scanner(Product_File);
                while (Reading_file.hasNextLine())
                {
                    String line =Reading_file.nextLine();
                    if(!line.contains(model))
                    {
                        f=true;
                    }
                    else {
                        f=false;
                        break;
                    }

                }
                File_writer( name, Company, model,f);


            }
            catch (IOException i)
            {

            }

        }
        else
        {
            File_Creating( name, Company, model,f);
        }
    }

    public void File_Creating(String name,String Company,String model,boolean f)
    {
        try {
            File Seller_file = new File("C:\\Data\\Product.txt");
            if (Seller_file.createNewFile()) {
                System.out.println("File created: " + Seller_file.getName());
                File_writer( name, Company, model,f);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void Removing_file(String model)
    {
        try
        {
            File file=new File("C:\\Data\\Product.txt");

            Scanner Reading_file=new Scanner(file);
            Scanner scanner=new Scanner(System.in);
            String value;
            String currentline;
            ArrayList<String> arrayList=new ArrayList<>();

            while (Reading_file.hasNextLine())
            {
                String line =Reading_file.nextLine();
                if(!line.contains(String.valueOf(model)))
                {
                    arrayList.add(line);
                }

            }
            Reading_file.close();
            if(file.delete())
            {
                System.out.println(file.getName()+"delete");
                File newfile=new File("C:\\Data\\Product.txt");
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


