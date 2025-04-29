package vehicles;

import constants.RentalConstants;

public class Car implements Vehicle {

    @Override
    public String getType() {
        return RentalConstants.CAR_TYPE;
    }

    @Override
    public int getRentalPricePerHour() {
        return RentalConstants.CAR_PRICE_PER_HOUR;
    }

    @Override
    public int calculateRentalCost(int hours) {
        return hours>0 ?RentalConstants.CAR_PRICE_PER_HOUR * hours:0;
    }
}

