import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializationexample {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("SerializationExampleOutputFile.txt"));
        Student student = (Student) inputStream.readObject();
        System.out.println(student);
        System.out.println("Student Class: "+student.Class+", Student name: "+student.name+", Id cannot be accessed as private., can be exposed with getter tho.");
    }
}
