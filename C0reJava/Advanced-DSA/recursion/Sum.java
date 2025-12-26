class Sum{
    void main(String ...args){
        IO.println(sum(5));
    }

    static int sum(int n){
        if(n == 1){
            return 1;
        }
        return n + sum(n-1);
    }
}