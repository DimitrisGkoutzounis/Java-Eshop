package Project.Entities;

public class Product {

    private double price, tax;
    private String title, category, description;

    public Product(double price, String title, String category, String description){
        
        this.price = price;
        this.tax=0.24;      //tax is common for all products
        this.title=title;
        this.category=category;
        this.description=description;

    }

    //GETTERS

    public double getPrice(){
        return this.price * this.tax;
    }

    public double getTax(){
        return this.tax;
    }

    public String getTitle(){
        return this.title;
    }

    public String getCategory(){
        return this.category;
    }

    public String getDescription(){
        return "Description: " + this.description;
    }

    //SETTERS

    public void setPrice(double price){
        this.price=price;
    }

    public void setTax(double tax){
        this.tax=price;
    }

    public void setTitle(String title){
        this.title=title;
    }
    
    public void setCategory(String category){
        this.category=category;
    }

    public void setDescription(String description){
        this.description=description;
    }

    
    
}