import java.util.*;

class Swap{
    public static void main(String ...args){
        int a=10, b=20;
        System.out.println("a: "+a+", b: "+b);

        a = a^b;
        b = a^b;
        a = a^b;

        System.out.println("a: "+a+", b: "+b);
    }
}

/*
Swapping two numbers using bit-wise XOR
*/