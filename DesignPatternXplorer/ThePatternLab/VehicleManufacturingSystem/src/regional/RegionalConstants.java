package regional;

public enum RegionalConstants {
    USA("US"), INDIA("IND"), EUROPE("EU");

    private final String regionalCode;

    RegionalConstants(String name){
        this.regionalCode = name;
    }

    public String getRegionalCode() {
        return regionalCode;
    }
}
