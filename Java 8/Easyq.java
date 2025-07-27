import java.util.Arrays;
import java.util.List;

public class Easyq {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Sagar","Ali","Yuvi","Fullgrey");

        names.stream().filter(n->n.startsWith("A")).forEach(System.out::println);
    }
}
