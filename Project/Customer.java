package Project;
public class Customer extends User{


    private String address;
    private String dateOfBirth;
    private Boolean newsletter=false;


    //CONSTRUCTOR
    public Customer(String name, String email, String number, String username, String password, String dateOfRegister, String address, String dateOfBirth, boolean newsletter){
        super(name, email, number, username, password, dateOfRegister);
        this.address=address;
        this.dateOfBirth=dateOfBirth;
        this.newsletter=newsletter;
    }
    public String getUserInfo(){
        return "|INFO| USER: " + getUsername() + " " + "NUMBER: " + getNumber() + " " + "EMAIL: " + getEmail();
    }


    public String getAddress(){
        return this.address;
    }
    public String getDateOfBirth(){
        return this.dateOfBirth;
    }
    public Boolean getNewsletter(){
        return this.newsletter;
    }




}