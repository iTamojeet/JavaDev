/*
Rule of Exception Handling with Method Overriding in Java:
1. if the parent version throws any exception then the child version can -
    a. throw same exception
    b. throw no exception
    c. not throw any exception which is the parent of it's parent
    d. throw any exception that is child of the parent
    e. throw multiple child exception
2. if the parent version does not throws any exception then the child version can not throw any exception
*/

public class Test25 {
    public static void main(String[] args) {
        S1 s1 = new S2();
        IO.println(s1.ff().getClass());
        try{

        }
        catch(Exception e){}
        try{

        }
        // Bootstrap or Primodial class loader is to load all system defined classes and load them in the jvm memory. Same way all exceptions are given in the catch body by this classloader.
        catch(ArithmeticException e){}
        catch(NullPointerException e){}
        catch(IndexOutOfBoundsException e){
            e = new ArrayIndexOutOfBoundsException();
        }

        ClassLoader cl = String.class.getClassLoader();
        IO.println(cl);
        cl = Test25.class.getClassLoader();
        IO.println(cl);
    }
}

class S1{
    // Covariant return type
    M ff(){
        return new M();
    }
}
class S2 extends S1{
    // Covariant return type
    N ff(){
        return new N();
    }
}
class M{}
class N extends M{}