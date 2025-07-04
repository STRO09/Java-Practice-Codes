import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Student implements Serializable{
    private int id;
    private String name;
    private int marks;

    public int getId(){
        return this.id;
    }

    public String getName() {
        return this.name;
    }


    public int getMarks() {
        return this.marks;
    }

    public String toString(){
        return "Student: { id: "+this.id+", name: "+this.name+", marks: "+this.marks+"}";
    }

    public Student(int id, String name, int marks) {

        this.id = id;
        this.name = name;
        this.marks= marks;
    }
}


public class ListSerialization {
    public static void main(String[] args) {
        Student s1 = new Student(1, "sagar",100);
        Student s2 = new Student(2, "Stro",99);
        Student s3 = new Student(3, "Theseus",98);

        List<Student> studentList = new ArrayList<Student>();
        studentList.add(s3);
        studentList.add(s1);
        studentList.add(s2);

        try (
            FileOutputStream fos = new FileOutputStream("SerializeList.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(studentList);
            System.out.println("Written succesfully.");

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
