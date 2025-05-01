package structuralPattern;

public class Decorator {

    public static void main(String[] args){

        // Normal Coffee Machine
        CoffeeMachine normalCoffeeMachine = new NormalCoffeeMachine();

        // New Coffee Machine
        NewCoffeeMachine newCoffeeMachine = new NewCoffeeMachine(normalCoffeeMachine);

        newCoffeeMachine.brewCoffee();
        newCoffeeMachine.addSugar();
        newCoffeeMachine.addMilk();
    }
}

/// Decorator : Wraps the whole interface/abstract class and override methods and uses the new and old features at the same time.
/// Also allows us to implements new methods as per our own requirement.

/// I want build a new coffee machine with existing features
class NewCoffeeMachine implements CoffeeMachine {

    private final CoffeeMachine normalCoffeeMachine;

    NewCoffeeMachine(CoffeeMachine coffeeMachine) {
        this.normalCoffeeMachine = coffeeMachine;
    }

    @Override
    public void brewCoffee() {
        System.out.println("New Coffee Machine uses the old mechanism of brewing coffee");
        normalCoffeeMachine.brewCoffee();
    }

    @Override
    public void addSugar() {
        System.out.println("New Coffee Machine uses the old mechanism of adding sugars");
        normalCoffeeMachine.addSugar();
    }

    // New machine has extra featured of adding milk
    public void addMilk() {
        System.out.println("New Coffee Machine : Adding Milk");
    }
}

///  Legacy interface (No control over the interface implementations )
interface CoffeeMachine {
    void brewCoffee();
    void addSugar();
}

class NormalCoffeeMachine implements CoffeeMachine {

    @Override
    public void brewCoffee() {
        System.out.println("Normal Machine : Brewing coffee ...");
    }

    @Override
    public void addSugar() {
        System.out.println("Normal Machine : Sugar cube added");
    }
}


