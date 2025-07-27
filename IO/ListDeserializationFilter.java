import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;


class Studentl {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class ListDeserializationFilter {
    public static void main(String[] args) {
        try(
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SerializeList.txt"));
        ){
            List<Studentl> studentlist =(List<Studentl>) ois.readObject();
            int i=1;
            System.out.println("Object read successfully. Below is the filtered output= ");
            for(Studentl student: studentlist){
                if(student.getId()==1){
                System.out.println(student);
                }
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
