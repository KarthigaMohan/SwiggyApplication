package repository;

import entity.DeliveryExecutive;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DeRepository {

    public DeRepository() {
        this.deliveryExecutivesList = new ArrayList<>();
    }

    private List<DeliveryExecutive> deliveryExecutivesList;

    public List<DeliveryExecutive> getDeliveryExecutivesList() {
        return deliveryExecutivesList;
    }

    public void setDeliveryExecutivesList(List<DeliveryExecutive> deliveryExecutivesList) {
        this.deliveryExecutivesList = deliveryExecutivesList;
    }
}
