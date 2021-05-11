package Project;
public class Administrator extends User{

    
    public Administrator(String name, String email, String number, String username, String password, String dateOfRegister){
        super(name, email, number, username, password, dateOfRegister);
    }

    public String getUserInfo(){
        return "INFO: USERS: " + getUsername() + " " + "NUMBER: " + getNumber() + " " + "EMAIL: " + getEmail();
    }
    


}