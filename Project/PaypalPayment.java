package Project;
public class PaypalPayment extends Payment {
    
    private String paypalAccount;

    public PaypalPayment(double payAmmount, String currency, String date, String paypalAccount){
        super(payAmmount, currency, date);
        this.paypalAccount=paypalAccount;
    }
    public String getPaypalAccount(){
        return this.paypalAccount;
    }

}