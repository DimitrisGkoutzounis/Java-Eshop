package Project;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

import Project.Entities.Product;

public class EshopData {
    
    private static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<Product> products = new ArrayList<Product>();
    

    public EshopData(){
        //default
    }
    //ARRAYLIST GETTER
    public static ArrayList<User> getUser(){
        return users;
    }
    public static ArrayList<Product> getProducts(){
        return products;
    }
  
}