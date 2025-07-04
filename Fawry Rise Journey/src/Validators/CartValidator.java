package Validators;

import Exceptions.EmptyCartException;
import Models.Cart;

public class CartValidator {
    private final ProductValidator productValidator;

    public CartValidator(){
        productValidator = new ProductValidator();
    }

    public void validateCart(Cart cart){
        var cartItems = cart.getAllItems();

        if(cartItems.isEmpty())
            throw new EmptyCartException("The cart is empty");

        for(var item : cartItems)
            productValidator.validateProduct(item.getKey(), item.getValue());
    }
}
