package Project;
public class CashOnDeliveryPayment extends Payment {
    
    private double deliveryCost;

    public CashOnDeliveryPayment(Double payAmmount, String currency, String date, double deliveryCost){
        super(payAmmount, currency, date);
        this.deliveryCost=deliveryCost;
    }
    public double getDeliveryCost(){
        return this.deliveryCost;
    }
}