class Stream{
    public static void main(String[] args) {
        IO.println(skip("abcdea"));
        IO.println(skipApple("abcdeapplefghi"));
        IO.println(skipAppNotApple("abcdeappfghijklapplemno"));
    }

    static String skip(String original){
        // base case, jodi original string empty hoy return the answer.
        if(original.isEmpty()){
            return "";
        }

        char ch = original.charAt(0);

        // only remove the 'a'(s) from the string
        if(ch == 'a'){
            return skip(original.substring(1));
        }
        else{
            return ch + skip(original.substring(1));
        }
    }

    static String skipApple(String original) {
        if (original.isEmpty()) {
            return "";
        }
        if (original.startsWith("apple")) {
            return skipApple(original.substring(5));
        } else {
            return original.charAt(0) + skipApple(original.substring(1));
        }
    }

    static String skipAppNotApple(String original) {
        if (original.isEmpty()) {
            return "";
        }
        if (original.startsWith("app") && !original.startsWith("apple")) {
            return skipAppNotApple(original.substring(3));
        } else {
            return original.charAt(0) + skipAppNotApple(original.substring(1));
        }
    }
}