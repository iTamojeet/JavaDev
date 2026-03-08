class Hi {
    static {
        System.out.println("Hellooooooooooooo");
    }

    public static void main(String[] args) {
        int i = 10;
        if (i > 100 & i++ > 0) {
        }
        System.out.println(i);
        i=10;
        System.out.println("_".repeat(69));
        if (i > 100 && i++ < 0) {
            System.out.println(i);
        }
        System.out.println(i);
        System.out.println("_".repeat(69));

        int x = 10;
        if (x < 20 | x++ > 5) {
        }
        System.out.println(x);
        x=10;
        System.out.println("_".repeat(69));
        if (x < 20 || x++ > 5) {
            System.out.println(x);
        }
        System.out.println(x);

        System.out.println(~5);

    }
}
