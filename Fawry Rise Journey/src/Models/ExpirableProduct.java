package Models;

import Interfaces.Expirable;

import java.time.LocalDate;
import java.util.Date;

public class ExpirableProduct extends Product implements Expirable {
    private LocalDate expirationDate;

    public ExpirableProduct(String name, double price, int quantity, LocalDate expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    @Override
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    @Override
    public void setExpirationDate(LocalDate date) {
        this.expirationDate = date;
    }
}
