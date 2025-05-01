package structuralPattern;

import java.util.*;
import java.util.stream.IntStream;

public class Flyweight {

    public static void main(String[] args){
        // Randomly generating army with user's choice value toDraw
        int toDraw = 1000;
        Army army = new Army();
        Random random = new Random();

        IntStream.range(1,toDraw).forEach(i -> {
            switch (random.nextInt(3)){
                case 0 -> army.spawnFighter(FighterRank.PRIVATE);
                case 1 -> army.spawnFighter(FighterRank.MAJOR);
                case 2 -> army.spawnFighter(FighterRank.SERGEANT);
            }
        });

        army.drawArmy();
    }
}

/// Flyweight - freeing up memory by shaping/forming and improves efficiency
/// when we use this - lot of similar objects


enum FighterRank{
    MAJOR,
    SERGEANT,
    PRIVATE;
}

record Fighter(FighterRank rank) {}

///  Flyweight core pattern
class FighterFactory {

    // a registry for each fighter with their rank respectively
    static Map<FighterRank, Fighter> fighters = new HashMap<>();

    public static Fighter getFighter(FighterRank rank) {
        if (fighters.containsKey(rank)){
            return fighters.get(rank);
        }
        fighters.put(rank, new Fighter(rank));
        return fighters.get(rank);
    }
}

class Army {

    private final List<Fighter> army = new ArrayList<>();

    public void spawnFighter(FighterRank rank){
        Fighter f = FighterFactory.getFighter(rank);
        army.add(f);
    }

    public void drawArmy() {
        army.forEach(f->{
            switch (f.rank()){
                case MAJOR -> System.out.print("M ");
                case PRIVATE -> System.out.print("P ");
                default -> System.out.print("S ");
            }
        });
    }
}



