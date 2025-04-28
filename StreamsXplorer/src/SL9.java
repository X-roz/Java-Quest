import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

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
}
