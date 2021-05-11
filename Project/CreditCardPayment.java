package Project;
public class CreditCardPayment extends Payment{

    private int cardNumber;
    private String ownername;
    private int pin;


    public CreditCardPayment(double payAmmount, String currency, String date, int cardNumber, String ownername, int pin){

        super(payAmmount, currency, date);
        this.cardNumber=cardNumber;
        this.ownername=ownername;
        this.pin=pin;
    }
    public int getCardNumber(){
        return this.cardNumber;
    }
    public String getOwnerName(){
        return this.ownername;
    }
    public int getPin(){
        return this.pin;
    }
}