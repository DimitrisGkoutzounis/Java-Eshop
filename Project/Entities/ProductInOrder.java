package Project.Entities;

public class ProductInOrder {
    
    private Product product;
    private int quantity=1;

    public ProductInOrder(){
        //default constructor
    }
    public ProductInOrder(Product product){
        this.product=product;
    }

    //GETTERS

    public Product getProduct(){
        return this.product;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public double getTotalPrice(){
        //Calculates the final price 
        return quantity * product.getPrice();
    }
    //SETTERS

    public void setProduct(Product product){
        this.product=product;
    }

    public void setQuantity(int quantity){
        this.quantity=quantity;
    }


}