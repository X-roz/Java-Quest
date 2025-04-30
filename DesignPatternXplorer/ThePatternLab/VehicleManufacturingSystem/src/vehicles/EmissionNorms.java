package vehicles;

public enum EmissionNorms {

    ///  Old Vehicles - emits more polluted air
    TIER_1("Tier-1"),

    /// emits less compared to Tier-1 vehicles
    TIER_2("Tier-2"),

    /// standard - emits less polluted air
    TIER_3("Tier-3");

    private final String type;

    EmissionNorms(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
