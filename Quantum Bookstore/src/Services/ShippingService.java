package Services;


import Models.PaperBook;

public class ShippingService {
    public void ship(PaperBook book,int quantity, String address) {
        System.out.println(book + " is sent to: " + address);
    }
}
