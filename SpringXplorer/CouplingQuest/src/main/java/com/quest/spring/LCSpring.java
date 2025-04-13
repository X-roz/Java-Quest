package com.quest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class LCSpring {

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
    @Component
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

    @Component
    public static class GameRunner {

        // Autowiring - Initialization of the GameConsole and based on user's preference game. That one will run from the multiple games
        @Autowired
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

        /* The initialization of Mario and GameRunner classes are done by Spring framework

        // User Chooses
        Mario mario = new Mario();

        // User preference - to start/run the game
        GameRunner gameRunner = new GameRunner(mario);

        */

        // run method will create a Spring Application Context - Manages all the component classes
        ConfigurableApplicationContext context = SpringApplication.run(LCSpring.class, args);

        // Any instance of the component class created is called Bean
        GameRunner runner = context.getBean(GameRunner.class);
        runner.start();

    }

}
