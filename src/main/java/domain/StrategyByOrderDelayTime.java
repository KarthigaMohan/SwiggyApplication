package domain;

import entity.RestaurantOrder;
import repository.OrderRepository;

import java.util.Comparator;
import java.util.List;

public class StrategyByOrderDelayTime implements DeliveryStrategy{

    private final OrderRepository orderRepository;

    public StrategyByOrderDelayTime(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void strategize(){
        List<RestaurantOrder> orderList = orderRepository.getOrderList();
        orderList.sort(Comparator.comparing(RestaurantOrder::orderedTime));
    }
}
