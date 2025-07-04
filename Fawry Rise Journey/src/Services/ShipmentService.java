package Services;
import Interfaces.IShipmentService;
import Interfaces.Shippable;
import java.util.List;

public class ShipmentService implements IShipmentService {

    @Override
    public double shippingCost(Shippable item) {
        return item.getWeight() * 0.1;
    }

    @Override
    public void ship(List<Shippable> items) {
        for(var item : items)
            System.out.println(item.getName() + " shipped");
    }
}
