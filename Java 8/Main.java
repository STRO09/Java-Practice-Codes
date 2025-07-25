import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.Arrays;
import java.util.List;


class Main{
public static void main(String args[]) {

// Given a list of integers, filter out even numbers using Predicate<Integer> and print them.

List<Integer> arr = Arrays.asList(2,46,2,7,37,8,75,4,54);
Predicate<Integer> isEven = n -> n%2==0;

for(Integer i: arr){
if(isEven.test(i)){
System.out.println(i);
}
}

// Given a list of strings, convert each to uppercase using Function<String, String>.
List<String> strlist = Arrays.asList("Hello","Motto","Bye bye", "JAva 7");
Function<String,String> toUpCase = str -> str.toUpperCase();

for(String str: strlist) {
System.out.println(toUpCase.apply(str));
}


//Take a list of names and print a welcome message for each using Consumer<String>.
List<String> names = Arrays.asList("Hello","Motto","Bye bye", "JAva 7");
Consumer<String> printname = str -> System.out.println("Welcome, "+str);

for(String str: names) {
printname.accept(str);
}

// Generate 5 random numbers using a Supplier<Double>.
Supplier<Integer> getrandomint = ()-> (int) (Math.random()*100);

for(int i=0;i<5;i++) {
System.out.println(getrandomint.get());
}

}
}