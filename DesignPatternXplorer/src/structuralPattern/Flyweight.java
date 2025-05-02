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
interface FighterPlacement {
    String position(int x, int y);
}

enum FighterRank{
    MAJOR,
    SERGEANT,
    PRIVATE;
}

record Fighter(FighterRank rank) implements FighterPlacement{
    @Override
    public String position(int x, int y) {
       return "I am standing at "+x+" , "+y;
    }
}

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
    Random random = new Random();

    public void spawnFighter(FighterRank rank){
        Fighter f = FighterFactory.getFighter(rank);
        army.add(f);
    }

    public void drawArmy() {
        army.forEach(f->{
            switch (f.rank()){
                case MAJOR -> System.out.println("M "+ f.position(random.nextInt(1,100), random.nextInt(101,200)));
                case PRIVATE -> System.out.println("P "+ f.position(random.nextInt(1,100), random.nextInt(101,200)));
                default -> System.out.println("S "+ f.position(random.nextInt(1,100), random.nextInt(101,200)));
            }
        });
    }
}



