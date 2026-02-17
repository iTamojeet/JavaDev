class Mango {
    String name;
}

public class Test{

    public static void modify(int x, Mango s) {
        x = 50;                // Changing primitive
        s.name = "Alfanzo";      // Modifying object
        s = new Mango();     // Reassigning reference
        s.name = "Himsagar";
    }

    public static void main(String[] args) {
        int num = 10;

        Mango m = new Mango();
        m.name = "Tamojeet";

        modify(num, m);

        System.out.println(num);
        System.out.println(m.name);
    }
}