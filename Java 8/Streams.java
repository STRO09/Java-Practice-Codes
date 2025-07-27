import java.util.List;
import java.util.Arrays;
import java.util.stream.*;
import java.util.Optional;


class User1 {
int id;
String name;
public User1(int id, String name) {

this.id=id;
this.name = name;
}

@Override 
public String toString() {

return "User1: [ id="+this.id+", name="+this.name+" ]";
}
}


class Streams {


public static void main(String[] args) {

//From a list of integers, filter even number square them collect into a new list

List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9);
List<Integer> evensquares = nums.stream().filter(n-> n%2==0).map(n->n*n).collect(Collectors.toList());

evensquares.forEach(System.out::println);
//  From a list of names, trim spaces convert to uppercase keep only names starting with V print them
List<String> names = Arrays.asList("Sagar","Stro","Sai","Shino","Vedika");

names.stream().map(String::trim).map(n->n.toUpperCase()).filter(n->n.startsWith("V")).forEach(System.out::println);

//From a list of User1 objects (id, name), filter users with id > 1, collect only their names into a List

List<User1> userlist = Arrays.asList(new User1(1,"Sagar"), new User1(2,"Stro"),new User1(3,"Murgi"));

List<User1> newuserlist =  userlist.stream().filter(n->n.id>1).collect(Collectors.toList());

newuserlist.forEach(System.out::println);

// From a list of words, find the first word with length > 4 print it using Optional.ifPresent()

List<String> words = Arrays.asList("Pen", "Rock","Paper","Scissor");
Optional<String> _4letterwords =words.stream().filter(n->n.length()>4).findFirst();
_4letterwords.ifPresent(System.out::println); 

}}