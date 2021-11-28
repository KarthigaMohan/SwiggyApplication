package entity;

import java.time.LocalDateTime;

public record RestaurantOrder(Location location, String orderID, LocalDateTime orderedTime) {
}
