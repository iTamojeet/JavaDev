class Test20 {
    public static void main(String ... args) {
        Thread t = Thread.currentThread();
        Thread tt = new Thread();
        tt=new Thread("tamo");
        tt.start();
        tt.run();
        String name = t.getName();
        System.out.println("Thread is: "+name);
        IO.println("Thread is: "+tt.getName());
        IO.println(args.length);

        int i[]= new int[100];
        IO.println(i.getClass());
    }
}

class A extends B {}
class B extends C {}
class C extends Object {}

interface I {
    public static void main(String[] args) {
        IO.println("I");
    }
}

record R() {
    public static void main(String[] args) {
        IO.println("R");
    }
}

enum E{
    E;
    public static void main(String[] args) {
        IO.println("E");
    }
}