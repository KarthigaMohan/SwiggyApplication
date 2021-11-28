package repository;

import entity.DeliveryExecutive;
import entity.RestaurantOrder;

import java.util.Map;

public class OrderDeRepository {

    public Map<RestaurantOrder, DeliveryExecutive> getOrderToDeMap() {
        return orderToDeMap;
    }

    private Map<RestaurantOrder, DeliveryExecutive> orderToDeMap;

    public void setOrderToDeMap(Map<RestaurantOrder, DeliveryExecutive> orderToDeMap) {
        this.orderToDeMap = orderToDeMap;
    }
}
