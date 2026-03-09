import java.util.function.Consumer;
import java.util.function.Predicate;

class test12 implements Predicate<Integer>{
    public boolean test(Integer i){
        if(i>100) return true;
        else return false;
    }
    public static void main(String[] args) {
        Predicate<Integer> pr = new test12();
        IO.println(pr.test(101));

        Predicate<Integer> pp = (x)->x>100?true:false;
        IO.println(pp.test(100));;
    }
}

class Aaram{
    static boolean haram(Predicate<Integer> pr, Integer i){
        return pr.test(i);
    }
    public static void main(String[] args) {
        IO.println(haram(x->x>100?true:false,100));

        Consumer<String> c = (q)->IO.println(q);
        c.accept("Tamo");
    }
}