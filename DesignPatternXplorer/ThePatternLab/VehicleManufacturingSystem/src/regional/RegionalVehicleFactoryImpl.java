package regional;


public class RegionalVehicleFactoryImpl {

    public static RegionalVehicleFactory getRegionalVehicleFactory(RegionalConstants rc) throws Exception {

        switch (rc){
            case USA -> {
                return new USAVehicleFactory();
            }
            case INDIA -> {
                return new IndiaVehicleFactory();
            }
            case EUROPE -> {
                return new EuropeVehicleFactory();
            }
            default -> throw new Exception("");
        }

    }

}
