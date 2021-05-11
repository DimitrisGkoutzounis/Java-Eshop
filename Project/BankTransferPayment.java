package Project;
public class BankTransferPayment extends Payment {

    private String accountName;
    private String beneficiary;
    private int iBAN;
    private String bankName; 

    public BankTransferPayment(double payAmmount, String currency, String date, int cardNumber, String ownername, int pin, String accountName, String beneficiary, int iBAN, String bankName){
        super(payAmmount, currency, date);
        this.accountName=accountName;
        this.beneficiary=beneficiary;
        this.iBAN=iBAN;
        this.bankName=bankName;
    }
    public String getAccountName(){
        return this.accountName;
    }
    public String getBeneficiary(){
        return this.beneficiary;
    }
    public int getIBAN(){
        return this.iBAN;
    }
    public String getBankName(){
        return this.bankName;
    }

}