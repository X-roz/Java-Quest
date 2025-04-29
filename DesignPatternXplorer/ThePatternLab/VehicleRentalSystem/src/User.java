import constants.RentalConstants;
import vehicles.Vehicle;
import vehicles.VehicleFactory;

public class User {

    public static void main(String[] args) {

        Vehicle userChoice1 = VehicleFactory.getVehicle(RentalConstants.BIKE_TYPE);
        if (userChoice1!= null){
            System.out.println("User's choice : "+ userChoice1.getType()+
                    " rental price per hour : "+ userChoice1.getRentalPricePerHour());

            System.out.println("For 2 hours rental price for "+ userChoice1.getType() +" : "+
                    userChoice1.calculateRentalCost(2));
        }else{
            System.out.println("ERROR: Invalid Vehicle type");
        }

        Vehicle userChoice2 = VehicleFactory.getVehicle(RentalConstants.CAR_TYPE);
        if (userChoice2!= null){
            System.out.println("User's choice : "+ userChoice2.getType()+
                    " rental price per hour : "+ userChoice2.getRentalPricePerHour());

            System.out.println("For 2 hours rental price for "+ userChoice2.getType() +" : "+
                    userChoice2.calculateRentalCost(2));
        }else{
            System.out.println("ERROR: Invalid Vehicle type");
        }

        Vehicle userChoice3 = VehicleFactory.getVehicle(RentalConstants.TRUCK_TYPE);
        if (userChoice3!= null){
            System.out.println("User's choice : "+ userChoice3.getType()+
                    " rental price per hour : "+ userChoice3.getRentalPricePerHour());

            System.out.println("For 2 hours rental price for "+ userChoice3.getType() +" : "+
                    userChoice3.calculateRentalCost(2));
        }else{
            System.out.println("ERROR: Invalid Vehicle type");
        }

        Vehicle userChoice4 = VehicleFactory.getVehicle("SUV");
        if (userChoice4 == null){
            System.out.println("ERROR: Invalid Vehicle type");
        }

    }
}