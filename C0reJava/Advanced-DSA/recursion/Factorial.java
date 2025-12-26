class Factorial{
    void main(String ...args){
        IO.println(fact(5));
    }

    static int fact(int n){
        if(n <= 1){
            return 1;
        }
        return n * fact(n-1);
    }
}