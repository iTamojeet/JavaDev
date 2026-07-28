class Test {
    private class Inner{}
    protected class Another{}
    private static class Wow{}

    static public void main(String[] args) {
        IO.println("Testing again...");
        float f = .7f;
        IO.println((double)f);
        IO.println(0/0.0); //NaN
        IO.println(0/1.0); //0.0
        IO.println(2.2/0.0); //Infinity
    }
}

class Test2 {
    private static void Main(String ...args){

    }
    static public void main(String[] args) {
        String java23 = """
                Wowwwwwwwww
                Interesting!!!
                """;
        IO.println("Testing all...");
    }
}