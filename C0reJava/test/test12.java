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
