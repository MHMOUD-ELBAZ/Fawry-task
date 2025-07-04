package Models;

import Interfaces.Expirable;

import java.time.LocalDate;
import java.util.Date;

public class ExpirableShippableProduct extends ShippableProduct implements Expirable {
    private LocalDate expirationDate;

    public ExpirableShippableProduct(String name, double price, int quantity, double weight, LocalDate expirationDate) {
        super(name, price, quantity, weight);
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
