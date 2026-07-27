import java.lang.annotation.Annotation;

class Test21 {
    public static void main(String[] args) {
        char c = 'a';
        String s = ""+c;
        IO.println(s);
        A.aa();
    }
}

abstract class A{
    static String name;
    static{
        name="tamo";
        IO.println(name);
    }
    static class B{
        static void bb(){
            IO.println("abstract B jali...");
        }
    }
    static void aa(){
        IO.println("abstract A jali...");
        B.bb();
    }
}

sealed class Loan{
    void amount(){
        IO.println("paisa");
    }
}
non-sealed class KeJane extends Loan{}
final class Client1 extends Loan{
    @Override //Mandatory method overriding
    void amount(){
        IO.println("paisa");
    }
}

public abstract interface test21 {
     
}