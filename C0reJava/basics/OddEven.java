public class OddEven {

    public static void main(String[] args) {
	    int n = 68;
        if(isOdd(n)){
            IO.println(n+" is odd.");
        }
        else{
            IO.println(n+" is even.");
        }
    }

    private static boolean isOdd(int n) {
        return (n & 1) == 1;
    }
}