class Test17 {
    public static void foo(Integer i){
        System.out.println("Integer");
    }
    public static void foo(short i){
        System.out.println("short");
    }
    public static void foo(long i){
        System.out.println("long");
    }
    public static void foo(int... i){
        System.out.println("var args");
    }
    public static void main(String[] args) {
        // foo(10);

        Animal a = new Dog();
        a.sound();
        a.run();

        new C().show();

        int i=5;
        i=i++;
        System.out.println(i);
        // i++;
        // System.out.println(i);
        System.out.println(i++);

        String s = null;
        s=s+" world";
        // s=s.concat(" world"); // After convert to string this can be done.
        System.out.println(s);
        System.out.println(s.length());
    }
}

class Animal{
    public static void sound(){
        System.out.println("Animal");
    }
    public void run(){
        System.out.println("Animal");
    }
}
class Dog extends Animal{
    public static void sound(){
        System.out.println("Dog");
    }
    @Override
    public void run(){
        System.out.println("Dog");
    }
}

interface A{
    default void show(){
        System.out.println("A");
    }
}
interface B{
    default void show(){
        System.out.println("B");
    }
}
class C implements A,B{
    public void show(){
        A.super.show();
    }
}