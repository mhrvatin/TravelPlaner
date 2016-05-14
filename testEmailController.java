


public class testEmailController {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String userName="marcus@hrvatin.se";
        EmailController emailTest=new EmailController(userName);
        String hash = "44klln2bv";
        
        emailTest.sendRecipt();
        emailTest.verify(hash);
    }
    
    
    
}
