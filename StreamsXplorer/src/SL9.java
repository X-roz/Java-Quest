import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;

public class SL9 {

    public static void main(String[] args) {

        try{
            /// File Handling using streams
            Files.lines(Paths.get("C:\\Users\\HP\\vk-works\\Java-learnings\\Java-Quest\\StreamsXplorer\\src\\sample.txt"))
                    .map(s->s.split(" "))
                    .flatMap(Arrays::stream)
                    .distinct()
                    .sorted()
                    .forEach(System.out::println);

            /// Directory lookup
            Files.list(Paths.get("C:\\Users\\HP\\vk-works\\Java-learnings\\Java-Quest"))
                    .filter(Files::isDirectory)
                    .forEach(System.out::println);

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void FunctionalThreads() {

        ///  Structural programming
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5000;i++){
                    System.out.println(Thread.currentThread().getId()+" : "+ i);
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.start();

        Thread thread2 = new Thread(runnable);
        thread2.start();

        /// Functional Programming
        Runnable runnableF = () -> {
            IntStream.range(1,1000).forEach(i->System.out.println(Thread.currentThread().getId()+" : "+ i));
        };

        Thread threadF1 = new Thread(runnableF);
        threadF1.start();

        Thread threadF2 = new Thread(runnableF);
        threadF2.start();
    }
}
