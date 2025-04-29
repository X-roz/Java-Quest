import lombok.Getter;

import java.util.ArrayList;

public class Composite {

    public static void main(String[] args){

        TTL computer = new TTL("computer");
        Equipment HDD =  new Equipment("HDD", 1200);
        Equipment processor = new Equipment("processor", 20);

        TTL memory = new TTL("memory");
        Equipment RAM =  new Equipment("RAM", 100);
        Equipment ROM = new Equipment("ROM", 80);

        memory.add(RAM).add(ROM);
        computer.add(HDD).add(processor).add(memory);

        System.out.println("PC price : " + computer.getPrice());

    }
}

/// Composite works very well for the tree structure within the system.
/// Manipulates many objects as a single one.

/// For instance, we need to get the price of the computer with respect to the equipments it has.

///  Tree's top layer
class TTL extends Equipment {

    private final ArrayList<Equipment> equipments = new ArrayList<>();

    TTL(String name) {
        super(name, 0);
    }

    public TTL add(Equipment equipment) {
        equipments.add(equipment);
        return this;
    }

    public int getPrice() {
        return equipments.stream().map(Equipment::getPrice).reduce(0, Integer::sum);
    }
}

/// Equipments layer
@Getter
class Equipment {
    private final String name;
    private final int price;

    Equipment(String name, int price) {
        this.name = name;
        this.price = price;
    }
}