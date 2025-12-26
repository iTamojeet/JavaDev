class Nto1{
    void main(String ...args){
        fun(5);
        IO.println("-".repeat(60));
        funReverse(5);
        IO.println("-".repeat(60));
        funBoth(5);
    }

    static void fun(int n){
        if(n == 0){
            return;
        }
        IO.println(n);
        fun(n-1);
    }

    static void funReverse(int n){
        if(n == 0){
            return;
        }
        funReverse(n-1);
        IO.println(n);
    }

    static void funBoth(int n){
        if(n == 0){
            return;
        }
        IO.println(n);
        funBoth(n-1);
        IO.println(n);
    }
}