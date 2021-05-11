package Project;
abstract class Payment {

    private double payAmmount;
    private String currency;
    private String date;

    public Payment(Double payAmmount, String currency, String date){
        this.payAmmount=payAmmount;
        this.currency=currency;
        this.date=date;
    }
    public double getPayAmmount(){
        return this.payAmmount;
    }
    public String getCurrency(){
        return this.currency;
    }
    public String getDate(){
        return this.date;
    }

}