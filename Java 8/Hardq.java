import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class EMPloyee {
    public String getName() {
        return name;
    }

    public EMPloyee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    String name;
    String department;
    double salary;
}

public class Hardq {

    public static void main(String[] args) {
        List<EMPloyee> employees = Arrays.asList(
                new EMPloyee("Alice", "HR", 40000),
                new EMPloyee("Bob", "IT", 50000),
                new EMPloyee("Charlie", "HR", 45000),
                new EMPloyee("David", "IT", 55000),
                new EMPloyee("Eva", "Finance", 60000)
        );

        Map<String,Double> deptavgsals= employees.stream().collect(Collectors.groupingBy(
                EMPloyee::getDepartment,Collectors.averagingDouble(EMPloyee::getSalary)
        ));
        System.out.println(deptavgsals);
    }
}
