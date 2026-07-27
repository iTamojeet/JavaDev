import java.lang.annotation.Annotation;

class Test {
    public static void main(String[] args) throws Exception {
        char c = 'a';
        String s = ""+c;
        IO.println(s);
        A.aa();

        int i = Integer.parseInt(args[0]);
        switch(i){
            case 10,20,30:IO.println(i); break;
            case 40:IO.println(i); break;
            case 50,60,70:IO.println(i); break;
            default:throw new Exception();
        }
        IO.println("-".repeat(10)); //unreachable statement
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

abstract interface Test21 {
     
}