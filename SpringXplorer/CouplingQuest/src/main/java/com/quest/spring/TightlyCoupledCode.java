package com.quest.spring;

public class TightlyCoupledCode {

    /// Let's try to create a gaming console which runs multiple games;

    /// we need at least one game installed to run it on console.
    public static class Mario {

        // Gaming operations
        public void up(){
            System.out.println("Jump");
        }

        public void down(){
            System.out.println("Stop");
        }

        public void left(){
            System.out.println("Back");
        }

        public void right(){
            System.out.println("Accelerate");
        }

    }

    ///  We need a class for Gaming Console to execute/start the game.
    public static class GameConsole {

        // Mario game
        private final Mario marioGame;
        // Lets Initialization the game on the console.
        public GameConsole(Mario m){
            this.marioGame = m;
        }

        public void run() {
            marioGame.up();
            marioGame.down();
            marioGame.left();
            marioGame.right();
        }
    }

    public static void main(String[] args) {

        Mario mg = new Mario();
        // Initialize the gaming console
        GameConsole gameConsole = new GameConsole(mg);
        // Start the game
        gameConsole.run();

    }

    /*
     Now, the GameConsole is tightly coupled with Mario game.
     But the requirement is to run the multiple games.
     By this way, the gameConsole is more dependent on Mario.
     */
}