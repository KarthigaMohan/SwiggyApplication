package controller;

import entity.DeliveryExecutive;
import entity.RestaurantOrder;
import service.SwiggyService;

import java.util.Map;

public class SwiggyController {

    private final SwiggyService swiggyService;

    public SwiggyController(SwiggyService swiggyService) {
        this.swiggyService = swiggyService;
    }

    public void addOrder(RestaurantOrder order) {
        swiggyService.addOrder(order);
    }

    public void addDeDetails(DeliveryExecutive de) {
        swiggyService.addDeDetails(de);
    }

    public Map<String, String> getAssignment() {
        return swiggyService.getAssignment();
    }
}
