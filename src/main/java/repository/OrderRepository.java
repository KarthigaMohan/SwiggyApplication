package repository;

import entity.RestaurantOrder;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    public OrderRepository() {
        this.orderList = new ArrayList<>();
    }

    private List<RestaurantOrder> orderList;

    public List<RestaurantOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<RestaurantOrder> orderList) {
        this.orderList = orderList;
    }
}
