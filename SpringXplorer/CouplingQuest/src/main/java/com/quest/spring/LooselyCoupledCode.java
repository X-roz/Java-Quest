package com.quest.spring;

public class LooselyCoupledCode {

    /// Let's try to create a gaming console which runs multiple games;

    ///  We need an interface for Gaming Console (Interface - a layer which will run multiple games with same buttons but different functionality)
    public interface GameConsole {

        // Buttons
        public void up();

        public void down();

        public void left();

        public void right();
    }

    /// install multiple games to connects it with (interface) GameConsole.
    public static class Mario implements GameConsole {

        // Mario operations for each buttons
        public void up(){
            System.out.println("Mario : Jump");
        }

        public void down(){
            System.out.println("Mario : Stop");
        }

        public void left(){
            System.out.println("Mario : Back");
        }

        public void right(){
            System.out.println("Mario : Accelerate");
        }

    }

    public static class Contra implements GameConsole {

        // Contra operations for each buttons
        public void up(){
            System.out.println("Contra : Jump");
        }

        public void down(){
            System.out.println("Contra : Stop");
        }

        public void left(){
            System.out.println("Contra : Back");
        }

        public void right(){
            System.out.println("Contra : Accelerate");
        }

    }

    public static class TempleRun implements GameConsole {

        // TempleRun operations for each buttons
        public void up(){
            System.out.println("TempleRun : Jump");
        }

        public void down(){
            System.out.println("TempleRun : Stop");
        }

        public void left(){
            System.out.println("TempleRun : Back");
        }

        public void right(){
            System.out.println("TempleRun : Accelerate");
        }

    }

    /// Now we have multiple games and an interface which will handle it.
    /// we need to start the game to play.
    public static class GameRunner {

        // Initialize the GameConsole and based on user's preference game. That one will run from the multiple games
        private  final GameConsole gameConsole;

        public GameRunner(GameConsole userPreference) {
            this.gameConsole = userPreference;
        }

        // Start/play button
        public void start() {
            gameConsole.up();
            gameConsole.down();
            gameConsole.left();
            gameConsole.right();
        }
    }

    public static void main(String[] args) {

        // User Chooses
        Mario mario = new Mario();
        Contra contra = new Contra();
        TempleRun templeRun = new TempleRun();

        // User preference - to start/run the game
        GameRunner gameRunner = new GameRunner(templeRun);
        gameRunner.start();
    }

    /*
     Now, the GameConsole is loosely coupled with Mario, contra, TempleRun games.
     we can add or remove any games to the console.
     IOC - Inversion of Control - Now the full control is over the Game Console (because of its independent nature)
     */

    /*
     Even though, we are able to run multiple games using interface.
     we need to assign the user's game choice with GameRunner and starts the game.
     If the user wants to change the game we need to run the whole application again with the new user's game choice.
     By using Spring framework, it will automatically take care of the initialization using Autowire annotation.
    * */
}