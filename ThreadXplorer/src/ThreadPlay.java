import java.util.List;
import java.util.Random;

public class ThreadPlay {

    /** Securing Vault from Hacker using Thread  **/

    // MAX pin digit
    private static final int MAX_PIN = 9999;

    public static void main(String[] args){

        // random pin generation
        Random random = new Random();

        // Vault declaration and Initialization
        Vault vault = new Vault(random.nextInt(MAX_PIN));

        // Hacker Threads and protection thread
        List<Thread> threads = List.of(new AscendingThread(vault),new DescendingThread(vault), new ProtectionThread());

        // Starts all the threads
        for(Thread t: threads){
            t.start();
        }

    }

    /** Vault Initialization **/
    public static class Vault {

        // 4 Digit pin
        private final int pin;

        // Constructor method
        public Vault(int pin){
            this.pin = pin;
        }

        // Method to verify the pin
        public boolean isValidPin(int pin){

            // try to stop the response for certain ms to handle the hackers
            try{
                Thread.sleep(5);
            }catch (InterruptedException e){
                System.out.println("Failed to validate pin!");
            }
            return this.pin == pin;
        }
    }

    /** Hacker Thread **/
    public static abstract class HackerThread extends Thread {

        // Initialize vault in Hacker Tread to identify the vault's pin
        protected final Vault vault;
        private HackerThread(Vault vault) {
            this.vault = vault;
        }
    }

    /** Ascending Thread **/
    public static class AscendingThread extends HackerThread {

        private AscendingThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for(int i=0;i<MAX_PIN;i++){
                if(vault.isValidPin(i)){
                    System.out.println("Ascending Thread steals the money!");
                    System.out.println("pin :"+ i);
                    System.exit(0);
                }
            }
        }
    }

    /** Descending Thread **/
    public static class DescendingThread extends HackerThread {

        private DescendingThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for(int i=MAX_PIN;i>0;i--){
                if(vault.isValidPin(i)){
                    System.out.println("Descending Thread steals the money!");
                    System.out.println("pin :"+ i);
                    System.exit(0);
                }
            }
        }
    }

    /** Protection Thread **/
    public static class ProtectionThread extends Thread{

        @Override
        public void run() {
            // wait for 10 seconds to close the session
            for (int i=10;i>0;i--){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Closing the session in "+ i);
            }
            System.out.println("Vault is Secured now !!");
            System.exit(0);
        }
    }
}

