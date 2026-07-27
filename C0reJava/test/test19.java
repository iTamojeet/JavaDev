import java.util.*;
class Test19{
    public static void main(String[] args) throws java.lang.Throwable {
        List<Object> list = new ArrayList<>();
        Collection<Object> coll = new LinkedList<>();
        coll=new Vector<>();
        coll=new Stack<>();
        coll=new PriorityQueue<>();
        coll=new ArrayDeque<>();


        Map<Object,Object> map = new TreeMap<>();
        // map = new AbstractMap<>();
        // map = new EnumMap<>();
        map = new HashMap<>();
        IO.println(map.getClass());
        IO.println(coll.getClass());
    }
    public static void main(String args) {
        
    }
}

class A{
    //this will compile but no main will be found at runtime.
    private static void main(String ...args){

    }
}
class B{
    {
        //this never runs.
        IO.println("1st normal block!!!");
    }
    static{
        IO.println("1st static block!!!");
    }
    public static void main(String[] args) {
        { IO.println("Main Thread!!!"); }
    }
    static{
        IO.println("2nd static block!!!");
    }
}