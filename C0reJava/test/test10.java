class test10 {
    test10(int ...args) throws Custom{
        if(args.length<1){
            throw new Custom("args must not be 0 or null");
        }
        IO.println("Length: "+args.length);;
        for(int r:args){
            IO.println(r);
        }
    }
    public static void main(String ...args) throws Custom{
        int[] i={};
        new test10(i);
    }
}
class Custom extends Exception{
    Custom(String message){
        super(message);
    }
}

class ABS{
    public static void main(String[] args) {
        H[] h={new HH(),new HH()};
        E[] e=new E[3];
        E w;
        E[] u=new N[3];
    }
}
abstract class H{}
class HH extends H{}
interface E {}
interface N extends E{}