package vehicles;

import static constants.VehicleTypes.CAR_TYPE;

public class Car implements Vehicle {

    @Override
    public String getType() {
        return CAR_TYPE.getType();
    }

    @Override
    public int getRentalPricePerHour() {
        return CAR_TYPE.getPrice();
    }

    @Override
    public int calculateRentalCost(int hours) {
        return hours>0 ? CAR_TYPE.getPrice() * hours:0;
    }
}

