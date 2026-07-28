import java.util.ArrayList;
import java.util.List;

class Test14 {
    
    int s;
    String n;
    Double d[];
    List<Boolean> lst = new ArrayList<>();


    public static void main(String[] args) {
        // public, private and protected not possible before local variable.
        // public int ha = 10;

        // test14 test14=80;
        Test14 test14=null;
        Test14 _dhur=new Test14();
        System.out.println(test14);
        System.out.println(_dhur);

        double []dd[]={{1.0,2.0,3.0},{4.0,5.0,6.0}};
    }
}
class A{
    int o;

    A(){}
    A(int o){ this.o = o; }

    public static void main(String[] args) {
        A a = new A();
        A aa = new A(0);
        System.out.println(a.o);
        System.out.println(aa.o);
        System.out.println(a.o == aa.o);
    }
}