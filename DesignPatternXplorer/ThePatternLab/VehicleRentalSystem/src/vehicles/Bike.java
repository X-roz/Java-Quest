package vehicles;

import static constants.VehicleTypes.BIKE_TYPE;

public class Bike implements Vehicle {

    @Override
    public String getType() {
        return BIKE_TYPE.getType();
    }

    @Override
    public int getRentalPricePerHour() {
        return BIKE_TYPE.getPrice();
    }

    @Override
    public int calculateRentalCost(int hours) {
        return hours>0 ? BIKE_TYPE.getPrice() * hours : 0;
    }
}
