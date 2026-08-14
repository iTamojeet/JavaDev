import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Test24 {

    public Test24(){}
    public Test24(double a){
        IO.println("Constructor says: "+a);
    }
    private Test24(String a){
        IO.println("Constructor says: "+a);
    }
    public static void main(String[] args) {
        IO.println(Pattern.matches("[abc]*", "ddd"));
        IO.println(Pattern.matches("\\d", "1"));
        IO.println(Pattern.matches("\\D", "1"));
        IO.println(Pattern.matches("\\w", "a"));
        IO.println(Pattern.matches("\\W", "a"));
        IO.println(Pattern.matches("[a-zA-Z0-9]", "test1"));

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9_.-]+$");
        Matcher matcher = pattern.matcher("paltamojeet@gmail.com");
        if (matcher.matches()) {
            IO.println("Valid email id.");
        } else {
            IO.println("Jali mail shalaaaa!!!");
        }

        pattern = Pattern.compile("^[6-9]\\d{9}$");

        matcher = pattern.matcher("9831812144");

        if (matcher.matches()) {
            IO.println("Valid Indian phone number.");
        } else {
            IO.println("Invalid Indian phone number.");
        }

        new Test24(-0);
        new Test24("a");
        new Test24('x');
        IO.println(new Test24().hashCode());
        IO.println(new Test24().hashCode());
        IO.println("a".hashCode()=="a".hashCode());
    }
}

class X{
    static{
        new Test24(-100);
        // new Test24("-a");
        new Test24('0');
    }
    public static void main(String[] args) {
        
    }
}