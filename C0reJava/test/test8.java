import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class Test8 implements A,B{
    @Override
    public void abc(){
        System.out.println("Hi");
        return;
    }
    public static void main(String[] args) {
        Test8 t = new Test8();
        t.abc();
        A a = new Test8();
        a.abc();
        B b = new Test8();
        b.abc();

        IO.println("-".repeat(69));
        List<String> s = new ArrayList<>();
        s.add("a");
        s.add("b");
        s.add("c");
        s.add("d");

        Iterator<String> i = s.listIterator();
        while(i.hasNext()){
            s.add("kk");
            break;
        }
        IO.println(Arrays.asList(s));

        /* Fail First Behaviour */

        // for(String d:s){
        //     s.remove(1); // Fail first behaviour
        //     s.add("igloo"); // Fail first behaviour
        //     IO.println(d);
        // }
    }
}

interface A{
    void abc();
}
interface B{
    void abc();
}