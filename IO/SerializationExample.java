import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable{
    private int id;
    String name;
    char Class;

    public Student(int id,String name,char Class){
        this.id =id;
        this.name=name;
        this.Class=Class;
    }

}
class SerializationExample {
    public static void main(String a[]) throws IOException {


        Student student = new Student(54, "Sagar janjoted", 'A');

        FileOutputStream fileOutputStream = new FileOutputStream("SerializationExampleOutputFile.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(student);
        objectOutputStream.flush();
        System.out.println("Successfully write performed in file");

    
        
    }
} 