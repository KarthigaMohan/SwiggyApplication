package entity;

import java.time.LocalDateTime;

public record DeliveryExecutive(String executiveId, Location location, LocalDateTime time) {
}
