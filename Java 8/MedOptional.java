import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

public class MedOptional
{
    static Map<String,String> usermail = new HashMap<>();

    public static Optional<String> findUserEmail(String name) {
        return Optional.ofNullable(usermail.get(name));
    };
    public static void main(String[] args) {

        usermail.put("Sagar","sagar123@");
        Optional<String> email = findUserEmail("Sag");

        String mail = email.orElse("No Email Found");
        System.out.println(mail);

    }
}
