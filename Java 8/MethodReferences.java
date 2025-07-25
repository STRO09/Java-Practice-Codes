import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.Supplier;

class User {
    int id;
    String name;
    public User(int id,String name){
        this.id=id;
        this.name=name;
    }
}

class MethodReferences{
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        List<String> names =Arrays.asList("Sagar","Prajwal","Ishika", "Vinay");
        names.forEach(System.out::println);
        Function<String,String> strtrim = String::trim;
        System.out.println(strtrim.apply("     Hello Motto"));
        Function<String,String> uppercaser = String::toUpperCase;
        System.out.println(uppercaser.apply("RequiRe"));
        Supplier<ArrayList<String>> givearray = ArrayList<String>::new;
        List<String> list = givearray.get();
        list.add("Sagar");
           list.add("Stro");
   list.add("Theseus");
   list.forEach(System.out::println);
   BiFunction<Integer,String,User> giveuserobj= User::new;
   
   User u1 = giveuserobj.apply(1,"Sagar");
   User u2 = giveuserobj.apply(2,"Stro");
   System.out.println(u1.id);
   System.out.println(u2.name);
   
   
   
        
    }
}