package Services;


import Models.EBook;

public class MailService {
    public void send(EBook book, String email){
        System.out.println(book +" is sent to: " + email);
    }
}
