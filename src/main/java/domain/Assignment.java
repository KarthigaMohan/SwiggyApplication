package domain;

import entity.DeliveryExecutive;
import entity.RestaurantOrder;

import java.util.Map;

public interface Assignment {

    Map<RestaurantOrder, DeliveryExecutive> assign();
}
