package domain;

import entity.DeliveryExecutive;
import repository.DeRepository;

import java.util.Comparator;
import java.util.List;

public class StrategyByDeWaitingTime implements DeliveryStrategy{

    private final DeRepository deRepository;

    public StrategyByDeWaitingTime(DeRepository deRepository) {
        this.deRepository = deRepository;
    }

    public void strategize(){
        List<DeliveryExecutive> deliveryExecutives = deRepository.getDeliveryExecutivesList();
        deliveryExecutives.sort(Comparator.comparing(DeliveryExecutive::time));
    }
}
