package behavioralPattern;

import java.util.Scanner;

public class State {
    
    public static void main(String[] args) {

        String mode = "";
        Game game = new Game();
        while (!mode.equals("end")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the mode : ");
            mode = scanner.nextLine();
            switch (mode) {
                case "w":
                    game.gameStates.welcome();
                    break;
                case "p":
                    game.gameStates.playing();
                    break;
                case "b":
                    game.gameStates.pause();
                    break;
                case "e":
                    game.gameStates.end();
                    break;
                case "end":
                    System.out.println("Thanks for playing");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;

            }
        }

    }
    
}

// Game
class Game {

    GameStates gameStates = new WelcomeState(this);

    public void changeState(GameStates s) {
        this.gameStates = s;
    }
}

// Game states
abstract class GameStates {
    
    Game game;
    
    GameStates(Game game){
        this.game = game;
    }

    abstract void welcome();
    abstract void playing();
    abstract void pause();
    abstract void end();
}

// Welcome - State Control
class WelcomeState extends GameStates {


    WelcomeState(Game game) {
        super(game);
        System.out.println("--- Welcome State ---");
    }

    @Override
    public void welcome() {
        System.out.println(" --- Welcome to the virtual reality world --- ");
    }

    @Override
    public void playing() {
        System.out.println("Entering Playing Mode");
        game.changeState(new PlayingState(this.game));
        game.gameStates.playing();
    }

    @Override
    public void pause() {
        System.out.println(" --- Not Allowed !! --- ");
    }

    @Override
    public void end() {
        System.out.println(" --- Not Allowed !! --- ");
    }
}

// Playing - State Control
class PlayingState extends GameStates {

    PlayingState(Game game) {
        super(game);
        System.out.println("--- Playing State ---");
    }

    @Override
    public void welcome() {
        System.out.println(" --- Not Allowed --- ");
    }

    @Override
    public void playing() {
        System.out.println(" --- playing --- ");
    }

    @Override
    public void pause() {
        System.out.println("Entering Break Mode");
        game.changeState(new PauseState(this.game));
        game.gameStates.pause();
    }

    @Override
    public void end() {
        System.out.println("Entering End Mode");
        game.changeState(new EndState(this.game));
        game.gameStates.end();
    }
}

// Pause - State Control
class PauseState extends GameStates {

    PauseState(Game game) {
        super(game);
        System.out.println("--- Pause State ---");
    }

    @Override
    public void welcome() {
        System.out.println(" --- Not Allowed --- ");
    }

    @Override
    public void playing() {
        System.out.println("Entering playing mode again ");
        game.changeState(new PlayingState(this.game));
        game.gameStates.playing();
    }

    @Override
    public void pause() {
        System.out.println(" --- Paused --- ");
    }

    @Override
    public void end() {
        System.out.println(" --- Not Allowed !! --- ");
    }
}

// End - State Control
class EndState extends GameStates {

    EndState(Game game) {
        super(game);
        System.out.println("--- End State ---");
    }

    @Override
    public void welcome() {
        System.out.println("Entering Welcome Mode");
        game.changeState(new WelcomeState(this.game));
        game.gameStates.welcome();
    }

    @Override
    public void playing() {
        System.out.println(" --- Not Allowed !! --- ");
    }

    @Override
    public void pause() {
        System.out.println(" --- Not Allowed !! --- ");
    }

    @Override
    public void end() {
        System.out.println(" --- Game Ended --- ");
    }
}