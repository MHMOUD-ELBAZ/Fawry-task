package Validators;

import Exceptions.ExpiredException;
import Exceptions.OutOfStockException;
import Interfaces.Expirable;
import Models.ExpirableProduct;
import Models.Product;

import java.time.LocalDate;
import java.util.Date;

public class ProductValidator {

    public void validateProduct(Product product, int quantity){
        validateQuantity(product, quantity);

        if(product instanceof Expirable)
            validateExpiration((Expirable) product);
    }

    private void validateQuantity(Product product, int quantity){
        if(quantity > product.getQuantity())
            throw new OutOfStockException("The available quantity of: " + product.getName() + " is " +
                    product.getQuantity()+  " unit.");
    }

    public void validateExpiration(Expirable product){
        if(product.getExpirationDate().compareTo(LocalDate.now()) < 0)
            throw new ExpiredException("Product is expired");
    }
}
