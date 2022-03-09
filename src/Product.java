import java.io.File;

public class Product {
    private String name;
    private String Company;
    private String model;
    public Product(String name,String company,String model)
    {
        this.Company=company;
        this.name=name;
        this.model=model;
    }
    //methods
public Product()
{

}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void Save(String name,String company,String model,boolean b)
    {
File_Product file_product=new File_Product();
file_product.File_Reader(name,company,model,b);
    }
    public void Remove(String model)
    {
        File_Product file_product=new File_Product();
        file_product.Removing_file(model);
    }
}
