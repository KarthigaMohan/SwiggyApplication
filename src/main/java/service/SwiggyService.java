package service;

import domain.Assignment;
import entity.DeliveryExecutive;
import entity.RestaurantOrder;
import repository.DeRepository;
import repository.OrderRepository;

import java.util.HashMap;
import java.util.Map;

public record SwiggyService(OrderRepository orderRepository, DeRepository deRepository,
                            Assignment assignment) {

    public void addOrder(RestaurantOrder order) {
        orderRepository.getOrderList().add(order);
    }

    public void addDeDetails(DeliveryExecutive de) {
        deRepository.getDeliveryExecutivesList().add(de);
    }

    public Map<String, String> getAssignment() {
        Map<RestaurantOrder, DeliveryExecutive> map = assignment.assign();
        Map<String, String> orderToDe = new HashMap<>();
        for (RestaurantOrder order : map.keySet()) {
            orderToDe.put(order.orderID(), map.get(order).executiveId());
        }
        return orderToDe;
    }

}
