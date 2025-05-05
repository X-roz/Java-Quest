public class TopEndCar implements Car{

    private final Car normalCar;

    TopEndCar(Car normalCar){
        this.normalCar = normalCar;
    }

    @Override
    public void addWheels() {
        System.out.println("Adding 4 spinning wheels (4X4)");
    }

    @Override
    public void addHeadlights() {
        normalCar.addHeadlights();
    }

    @Override
    public void addIndicators() {
        normalCar.addIndicators();
        System.out.println("Adding straight strip indicator at the back");
    }


}
