package Models;
import Interfaces.IShipmentService;
import Interfaces.Shippable;
import Validators.ProductValidator;

import java.util.*;

public class Cart {
    private Map<Product, Integer> productQuantity;
    private ProductValidator validator;
    private IShipmentService shipmentService;
    private double subTotal, shippingFees;

    public Cart(IShipmentService shipmentService){
        productQuantity = new HashMap<>();
        validator = new ProductValidator();
        this.shipmentService = shipmentService;
    }

    public void addItem(Product product, int quantity){
        validator.validateProduct(product, quantity);

        productQuantity.put(product, productQuantity.getOrDefault(product, 0) + quantity);
        subTotal += quantity * product.getPrice();

        if(product instanceof Shippable)
            shippingFees += shipmentService.shippingCost((Shippable) product) * quantity;
    }

    public Set<Map.Entry<Product, Integer>> getAllItems(){
        return productQuantity.entrySet();
    }

    public double getSubTotal(){
        return subTotal;
    }

    public double getShippingFees() {
        return shippingFees;
    }
}
