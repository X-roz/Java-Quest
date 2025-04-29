package vehicles;

import static constants.VehicleTypes.TRUCK_TYPE;

public class Truck implements Vehicle {

    @Override
    public String getType() {
        return TRUCK_TYPE.getType();
    }

    @Override
    public int getRentalPricePerHour() {
        return TRUCK_TYPE.getPrice();
    }

    @Override
    public int calculateRentalCost(int hours) {
        return hours>0 ? TRUCK_TYPE.getPrice() * hours:0;
    }
}
