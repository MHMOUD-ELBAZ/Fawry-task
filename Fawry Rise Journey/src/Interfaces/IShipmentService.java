package Interfaces;

import java.util.List;

public interface IShipmentService {
    double shippingCost(Shippable item);
    void ship(List<Shippable> items);
}
