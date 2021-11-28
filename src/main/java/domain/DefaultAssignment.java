package domain;

import entity.DeliveryExecutive;
import entity.RestaurantOrder;
import repository.DeRepository;
import repository.OrderDeRepository;
import repository.OrderRepository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DefaultAssignment implements Assignment{

    private final OrderRepository orderRepository;
    private final DeRepository deRepository;
    private final OrderDeRepository orderDeRepository;
    private final StrategyByDeWaitingTime strategyByDeWaitingTime;
    private final StrategyByOrderDelayTime strategyByOrderDelayTime;

    public DefaultAssignment(OrderRepository orderRepository, DeRepository deRepository, OrderDeRepository orderDeRepository) {
        this.orderRepository = orderRepository;
        this.deRepository = deRepository;
        this.orderDeRepository = orderDeRepository;
        this.strategyByDeWaitingTime = new StrategyByDeWaitingTime(deRepository);
        this.strategyByOrderDelayTime = new StrategyByOrderDelayTime(orderRepository);
    }

    public Map<RestaurantOrder, DeliveryExecutive> assign(){
        strategyByDeWaitingTime.strategize();
        strategyByOrderDelayTime.strategize();

        Map<RestaurantOrder, DeliveryExecutive> map = new HashMap<>();
        int deNumber = 0;
        for (RestaurantOrder order: orderRepository.getOrderList()){
            if (deNumber < deRepository.getDeliveryExecutivesList().size()){
                map.put(order, deRepository.getDeliveryExecutivesList().get(deNumber));
                deNumber++;
            }
            else break;
        }
        orderDeRepository.setOrderToDeMap(map);
        return map;
    }



}
