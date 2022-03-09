import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class File_Seller {
    //creating file
    private boolean a,b=false;

    public void Creating_File(String User,int Password) throws IOException
    {
        try {
            File Seller_file = new File("C:\\Data\\Seller.txt");
            if (Seller_file.createNewFile()) {
                System.out.println("File created: " + Seller_file.getName());
                Writing_File(User,Password);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



    //Reading file
    public void Reading_File(String User,int Password)
    {
File Seller_File=new File("C:\\Data\\Seller.txt");
if(Seller_File.exists())
{
    try {
        Scanner Myreader=new Scanner(Seller_File);
        while(Myreader.hasNextLine())
        {
            String user=Myreader.nextLine();
            if(user.matches(User) )
            {
                 a=true;
                System.out.println("Right Username");
            }
            else if(user.matches(String.valueOf(Password)))
            {
                 b=true;
                System.out.println("Right Password");

            }

        }
        if (a==false ||b==false)
        {
            System.out.println("username or password was incorrect");
            System.exit(0);
        }

    }
    catch (IOException io)
    {

    }
}
else{
    try {
        Creating_File(User,Password);
    }
    catch (IOException ie)
    {
        System.out.println("An error occurred.");
        ie.printStackTrace();
    }
}
    }




    //writing file
    public void Writing_File(String User,int Password)
    {
        try {
            FileWriter Seller_File = new FileWriter("C:\\Data\\Seller.txt");
            Seller_File.write("new User"+"\n");
            Seller_File.write("Username: "+"\n"+User+"\n");
            Seller_File.write("National_id: "+"\n"+String.valueOf(Password));
            Seller_File.write("\n");
            Seller_File.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void Removing_file(String User,int Password)
    {
        try
        {
            File file=new File("C:\\Data\\Seller.txt");
boolean aa=false;
boolean bb=false;
            Scanner Reading_file=new Scanner(file);
            Scanner scanner=new Scanner(System.in);
            String value;
            String currentline;
            ArrayList<String> arrayList=new ArrayList<>();

            while (Reading_file.hasNextLine())
            {
                String line =Reading_file.nextLine();
                if(line.contains(User))
                {
                     aa=true;
                }
                else if(line.contains(String.valueOf(Password)))
                {
                    bb=true;
                }

            }
            Reading_file.close();
            if(aa==true&&bb==true)
            {
                System.out.println("the user and the password was correct");
                if (file.delete())
                {
                    System.out.println(file.getName()+" "+"delete");
                }
            }
            if(file.delete())
            {
                System.out.println(file.getName()+" "+"delete");
                File newfile=new File("C:\\Data\\Seller.txt");
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

