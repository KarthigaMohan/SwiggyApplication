package application;

import controller.SwiggyController;
import domain.Assignment;
import domain.DefaultAssignment;
import entity.DeliveryExecutive;
import entity.Location;
import entity.RestaurantOrder;
import repository.DeRepository;
import repository.OrderDeRepository;
import repository.OrderRepository;
import service.SwiggyService;

import java.time.LocalDateTime;

public class ApplicationMain {

    public static void main(String[] args){

        OrderRepository orderRepository = new OrderRepository();
        DeRepository deRepository = new DeRepository();
        OrderDeRepository orderDeRepository = new OrderDeRepository();
        Assignment defaultAssignment = new DefaultAssignment(orderRepository, deRepository, orderDeRepository);
        SwiggyService service = new SwiggyService(orderRepository, deRepository, defaultAssignment);
        SwiggyController controller = new SwiggyController(service);

        RestaurantOrder order1 = new RestaurantOrder(
                new Location(12.34533, 77.34343),
                "123",
                LocalDateTime.of(2021, 11, 20, 11, 38));
        RestaurantOrder order2 = new RestaurantOrder(
                new Location(12.34533, 77.34343),
                "456",
                LocalDateTime.of(2021, 11, 20, 10, 34));
        RestaurantOrder order3 = new RestaurantOrder(
                new Location(12.34533, 77.34343),
                "789",
                LocalDateTime.of(2021, 11, 20, 8, 49));
        controller.addOrder(order1);
        controller.addOrder(order2);
        controller.addOrder(order3);

        DeliveryExecutive de1 = new DeliveryExecutive("abc",
                new Location(12.34533, 77.34343),
                LocalDateTime.of(2021, 11, 20, 12, 33));
        DeliveryExecutive de2 = new DeliveryExecutive("def",
                new Location(12.34533, 77.34343),
                LocalDateTime.of(2021, 11, 20, 11, 35));

        controller.addDeDetails(de1);
        controller.addDeDetails(de2);
        System.out.println(controller.getAssignment());



    }

}
