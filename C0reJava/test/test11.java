class test11 extends F implements SS{
    public void a(){}
    public void a(int i){}
    public static void main(String[] args) {
        R r = (w)->{
            int x = 10;
            try{
                int f = x/w;
            }catch(ArithmeticException e){
                IO.println(e);
            }
        };
        r.div(0);
    }
}
interface SS{
    void a();
    void a(int i);
}
class F{
    void a(){}
}
interface R{
    void div(int a);
}