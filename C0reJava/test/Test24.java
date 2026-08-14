import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test24 {
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
    }
}
