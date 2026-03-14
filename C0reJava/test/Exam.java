class Exam {
    static int rr(){
        try{
            return 1;
        }
        catch(Exception e){
            return 0;
        }
        finally{
            return 3;
        }
    }
    public static void main(String[] args) {
        // String s1 = "hello";
        // String s2 = new String("hello");

        // s2 = s2.intern();
        // System.out.println(s1 == s2);

        // System.out.println('j'+'a'+'v'+'a');

        // // return override
        // System.out.println(rr());

        // System.out.println(10+20+'a'+"AAA");

        // try{
        //     System.out.println("try");;
        //     System.exit(0);
        // }
        // catch(Exception e){
        //     System.out.println(e);;
        // }
        // finally{
        //     System.out.println("finally");;
        // }

        C c = new C();
        new Child().display();
        System.out.println(new W().div(10, 0));
        System.out.println(new Bara().any());
    }
}

class A{
    static{
        IO.println("A");
    }
}
class B extends A{
    static{
        IO.println("B");
    }
}
class C extends B{
    static{
        IO.println("C");
    }
}

class Parent{
    private void print(){
        IO.println("PARENT");
    }

    public void display(){
        print();
    }
}
class Child extends Parent{
    public void print(){
        IO.println("CHUILD");
    }
}

class W{
    static int div(int a, int b){
        try{
            return a/b;
        }
        catch(ArithmeticException e){
            System.out.println(e);
            return -1;
        }
        finally{
            System.out.println("ORE BABA finally!!!");
        }
    }
}

class Bara{
    static int any(){
        int i = 1;
        try{
            i = i + 1; //2
            return i;
        }
        catch(ArithmeticException e){
            i = i + 2;
        }
        finally{
            i = i + 3; //5
        }
        return i;
    }
}