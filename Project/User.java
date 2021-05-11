package Project;
abstract class User{

    private String name;
    private String email;
    private String number;
    private String username;
    private String password;
    private String dateOfRegister;

    public User(String name, String email, String number, String username, String password, String dateOfRegister){
        this.name=name;
        this.email=email;
        this.number=number;
        this.username=username;
        this.password=password;
        this.dateOfRegister=dateOfRegister;
    }

    abstract String getUserInfo();


    public String getEmail(){
        return this.email;
    }
    public String getUsername(){
        return this.username;
    }
    public String getNumber(){
        return this.number;
    }
    public String getPassword(){
        return this.password;
    }
    public String getName(){
        return this.name;
    }
    public String getDateOfRegister(){
        return this.dateOfRegister;
    }



}