import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

class Test15 {
    // High Order function has any number of anonymous or lambda function in it's
    // parameter.
    static void highOrder(List<Integer> nums, Predicate<Integer> predicate) {
        for (int i : nums) {
            if (predicate.test(i))
                System.out.println(i);
        }
    }

    static int high2(int r1, int r2, BinaryOperator<Integer> h){
        return h.apply(r1, r2);
    }

    public static void main(String[] args) {
        List<Integer> lst = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        highOrder(lst, num -> num % 2 == 0);
        System.out.println("-".repeat(69));

        /*
         * Predicate<T> boolean value lambda
         * Function<T, R> takes a input and produce a result
         * Consumer<T> an operation accept a single i/p and return no result
         * Supplier<T> represents a supplier of results
         */
        Predicate<Integer> pr = num -> num % 2 != 0;
        IO.println(pr.test(12));
        Function<String, Integer> f1 = str -> str.length();
        IO.println(f1.apply("TAMO"));
        Consumer<String> c = message -> IO.println(message);
        c.accept("Tamo");
        Supplier<Double> sp = () -> Math.random() * 100;
        IO.println(sp.get());
        System.out.println("-".repeat(69));

        // How lambda expression helps in java collection and stream API?
        List<Integer> dhur = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        dhur.stream().filter(pr).forEach(k -> IO.println(k));
        System.out.println("-".repeat(69));

        Greeting g = t->IO.println("Hello "+t);
        g.greet("Tamo Sir");

        // What is effectively final requirement in lambda expression
        int count = 0;
        // count = 10;
        Runnable r = ()->IO.println(count);
        r.run();
        System.out.println("-".repeat(69));

        // Method Reference (MR) -> coincise syntax for lambda
        // Static MR
        int v = Integer.parseInt("100");
        IO.println(v);
        Function<String, Integer> vv = Integer::parseInt;
        IO.println(vv.apply("123"));
        IO.println(Math.max(999, 2));
        BiFunction<Integer, Integer, Integer> fg = Math::min;
        IO.println(fg.apply(0, 1));

        // Instance MR
        String s = "Hi";
        Supplier<Integer> pp = s::length;
        IO.println(pp.get());

        /* How lambda expression affect performance compared to anonymous inner-class
        lambda function do not create aditional class files. They convert into invokedynamic bytecode instruction which is highly memory efficient.
        */

        // What is negation in lambda?
        Predicate<Integer> prd = z->z%2==0;
        Predicate<Integer> prd_n = prd.negate();
        IO.println(prd_n.test(10));

        // Combine predicates
        Predicate<Integer> oddAndLessThanTen = prd.negate().and(d -> d>10);
        IO.println(oddAndLessThanTen.test(12));

        // Unary operator are used when i/p & o/p type are same.
        UnaryOperator<Integer> o = x->x+1;
        IO.println(o.apply(10));

        BinaryOperator<Integer> o2 = (x,y)->x+y;
        IO.println(o2.apply(10,20));

        IO.println(high2(55, 66, (x,y) -> x+y));
    }
}

@FunctionalInterface
interface Greeting {
    void greet(String message);
    default void print() {}
    static void log() {}
    @Override
    String toString();
}

sealed abstract class A permits L1,L2{
    abstract void loan();
}
non-sealed class L1 extends A{
    void loan(){}
}
final class L2 extends A{
    void loan(){}
}

// @FunctionalInterface not allowed for sealed interface
sealed interface I{
    void g();
}
non-sealed interface I1 extends I{}
// SAM - sealed abstract method