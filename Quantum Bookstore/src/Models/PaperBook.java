package Models;

import Exceptions.NotAvailableException;
import Services.ShippingService;

public class PaperBook extends Book implements Buyable{
    private int quantity;

    public PaperBook(String ISBN, String title, double price, int publishingYear, int quantity) {
        super(ISBN, title, price, publishingYear);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double buy(int quantity, String email, String address) {
        if(quantity > this.getQuantity())
            throw new NotAvailableException("Not enough quantity in the inventory");

        ShippingService service = new ShippingService();
        service.ship(this,quantity,address);

        return quantity * this.getPrice();
    }
}
