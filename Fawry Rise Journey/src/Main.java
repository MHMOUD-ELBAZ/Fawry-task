import Exceptions.InsufficientBalanceException;
import Interfaces.IShipmentService;
import Interfaces.Shippable;
import Models.*;
import Services.ShipmentService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ShippableProduct tv = new ShippableProduct("tv", 2500, 10, 2000);
        ShippableProduct mobile = new ShippableProduct("mobile", 1500, 10, 250);
        ExpirableShippableProduct cheese = new ExpirableShippableProduct("cheese", 30,50,500, LocalDate.of(2026,1,1));

        Customer customer = new Customer("Mahmoud elbaz", 100000);
        IShipmentService service = new ShipmentService();
        Cart cart = new Cart(service);

        try{
            cart.addItem(tv, 3);
            cart.addItem(mobile, 3);
            cart.addItem(cheese, 6);
            checkout(customer, cart);

            List<Shippable> list = new ArrayList<>();
            for(var item : cart.getAllItems())
                list.add((Shippable) item.getKey());

            service.ship(list);
        }catch (Exception ex){
            System.out.println("Failure: " + ex.getMessage());
        }
    }


    public static void checkout(Customer customer, Cart cart){
        double total = cart.getSubTotal() + cart.getShippingFees();
        if(customer.getBalance() < total)
            throw new InsufficientBalanceException("Your balance is not enough, recharge and try again");

        customer.setBalance(customer.getBalance() - total);
        printInvoice(cart);
        System.out.println("Your balance now is = " + customer.getBalance());
        System.out.println("----------------------------------");
    }

    public static void printInvoice(Cart cart){
        System.out.println("** Checkout receipt **");
        System.out.println("Quantity \t product \t price \t weight");
        System.out.println("----------------------------------");

        int totalWeight=0;
        for (var item : cart.getAllItems()){
            Product product = item.getKey();

            double weight = ( product instanceof Shippable ? ((Shippable)product).getWeight() : 0);
            totalWeight += weight;

            System.out.println(item.getValue() +"x    \t" + product.getName() + "\t" + product.getPrice()
             +"   \t"+ (weight == 0 ? "---" : weight) );
        }

        System.out.println("----------------------------------");
        System.out.println("Total weight = " + totalWeight);
        System.out.println("Subtotal = " + cart.getSubTotal());
        System.out.println("Shipping = " + cart.getShippingFees());
        System.out.println("Amount = " + (cart.getSubTotal() + cart.getShippingFees()));
        System.out.println("----------------------------------");
    }
}