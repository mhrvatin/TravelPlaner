public class PaymentController{
    private BankMock bank;
    private String user;
    private int cardNr;
    private int price;
    public PaymentController(){
        bank=new BankMock();
        cardNr=0;
        price=0;
        user="";
    }
    public PaymentController(int cardNr, int price, String user){
        bank=new BankMock();
        this.cardNr=cardNr;
        this.price=price;
        this.user=user;
    }
    public Boolean makePayment(){
        Boolean accepted=false;

        return accepted;
    }
    private Boolean logTranscation(){

        return true;
    }
}