import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ListDeserialization {
    public static void main(String[] args) {
        try(
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SerializeList.txt"));
        ){
            List<Student> studentlist =(List<Student>) ois.readObject();
            int i=1;
            System.out.println("Object read successfully. Below is the output= ");
            for(Student student: studentlist){
                System.out.println(student);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
