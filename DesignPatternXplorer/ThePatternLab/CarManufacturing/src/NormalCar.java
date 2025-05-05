public class NormalCar implements Car{

    @Override
    public void addWheels() {
        System.out.println("Adding 2 spinning and 2 non-spinning wheels ");
    }

    @Override
    public void addHeadlights() {
        System.out.println("Adding 2 headlights");
    }

    @Override
    public void addIndicators() {
        System.out.println("Adding 4 indicators");
    }
}
