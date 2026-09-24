import java.util.Random;

public class Test26 {
    public static void main(String[] args) {
        IO.println(RandomString.randomString(5));

        String sentence = "hi.  hi hihi    -   hi  hi hi    hi.";
        IO.println(sentence.replaceAll("\\s",""));
    }
}

class RandomString{
    static String randomString(int size){
        StringBuffer sb = new StringBuffer();

        Random random = new Random();

        for(int i = 0; i<size; i++){
            int randomChar = 97 + (int)(random.nextDouble() * 26);
            sb.append((char)randomChar);
        }

        return sb.toString();
    }
}