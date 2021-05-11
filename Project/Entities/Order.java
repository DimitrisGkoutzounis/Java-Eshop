package Project.Entities;

import java.util.ArrayList;

import Project.Customer;

public class Order {
    
    private ArrayList<ProductInOrder> products = new ArrayList<ProductInOrder>();
    private Customer customer;
    
    //GETTER
    public ArrayList<ProductInOrder> getProdcucts(){
        return this.products;
    }
    //SETTERS

    public void setProducts(ArrayList<ProductInOrder> products){
        this.products=products;
    }

    public double getTotalPrice(){
        double finalPrice = 0;

        for(int counter=0; counter < products.size(); counter++ ){
            finalPrice += products.get(counter).getTotalPrice();
        }
        return finalPrice;
    }






}