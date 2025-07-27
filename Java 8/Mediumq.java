import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mediumq {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,1);
        List<Integer> newnums= nums.stream().filter(n-> n%2==0).map(n-> n*n).collect(Collectors.toList());
        newnums.forEach(
                System.out::println
        );

    }
}
