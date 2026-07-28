class Test6 {
    public static void main(String[] args) {
        call(10);
        X.demo();

        // while(12==12l) System.out.println("HI"); // INFINITE "HI"
    }
    static void call(int i){
        i++;
    }
}
class X{
    static void demo(){
        System.out.println(100);;
    }
}