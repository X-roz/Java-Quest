package vehicles;

import constants.RentalConstants;

public class Truck implements Vehicle {

    @Override
    public String getType() {
        return RentalConstants.TRUCK_TYPE;
    }

    @Override
    public int getRentalPricePerHour() {
        return RentalConstants.TRUCK_PRICE_PER_HOUR;
    }

    @Override
    public int calculateRentalCost(int hours) {
        return hours>0 ? RentalConstants.TRUCK_PRICE_PER_HOUR * hours:0;
    }
}
