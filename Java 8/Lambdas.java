import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface 
interface Printer {
void print(String msg);
}

interface Multiplier   {
int multiply(int a, int b);
}


public class Lambdas {
    public static void main(String[] args) {
	Printer pr = (msg) ->  System.out.println("Message: "+msg);
	pr.print("Who let the dogs out?");
	// Multiplier ml = (a, b) -> {return a*b;};
	 Multiplier ml = (a, b) -> a*b;
	System.out.println(ml.multiply(4,5));
	Consumer<String> takename = (name) ->  System.out.println("Welcome, "+name);
	takename.accept("Sagar");
	Supplier<String> sp = () -> java.util.UUID.randomUUID().toString();
	System.out.println(sp.get());
	Function<String,String> fn= (str) -> str.toUpperCase();
	System.out.println(fn.apply("Hello New World"));
	Predicate<String> checkInitialA = (str) -> str.charAt(0) == 'A';
	System.out.println(checkInitialA.test("Aradhana"));
	System.out.println(checkInitialA.test("Sagar"));
	

	
  }
}