class Test5 {
    public static void main(String[] args) {
        int a = 50, b = 10;
        int c = a + b;
        assert c >= 100 : "I am sorry!!!!";
        System.out.println("c is " + c);

        IO.println("-".repeat(69));

        final String h = "he";
        String i = h + "llo";
        System.out.println(i == "hello"); // true
        String g = "he";
        i = g + "llo";
        System.out.println(i == "hello"); // false

        IO.println("-".repeat(69));

        String s1 = "Java";
        String s2 = "Ja" + "va";
        String s3 = new String("Java");

        System.out.println("s1 == s2 " + (s1 == s2));
        System.out.println("s1 == s3 " + (s1 == s3));
        System.out.println("s1.equals(s3) " + s1.equals(s3));

        IO.println("-".repeat(69));

        final String x = "he";
        String y = "llo";

        String z = x + y;

        System.out.println(z == "hello");
        System.out.println(z == x+"llo");

        IO.println("-".repeat(69));
    }
}