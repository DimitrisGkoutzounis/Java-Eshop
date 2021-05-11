package Project;
public class Suppilier extends User {
    
    private String brand;
    private String tin;


    public Suppilier(String name, String email, String number, String username, String password, String dateOfRegister, String brand, String tin){
        super(name, email, number, username, password, dateOfRegister);
        this.brand=brand;
        this.tin=tin;
    }

    //GETTERS
    public String getBrand(){
        return this.brand;
    }
    public String getTin(){
        return this.tin;
    }
    //SETTERS
    public void setBrand(String brand){
        this.brand=brand;
    }
    public void setTin(String tin){
        this.tin=tin;
    }

    public String getUserInfo(){
        return "INFO: USERS: " + getUsername() + " " + "NUMBER: " + getNumber() + " " + "EMAIL: " + getEmail() + " " + this.tin ;
    }


}