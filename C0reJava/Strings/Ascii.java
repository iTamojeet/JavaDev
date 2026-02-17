class Ascii {
    public static void main(String[] args) {
        char ch = 'a';
        char chh = 'A';
        IO.println(ch+" "+(int) ch);
        IO.println(chh+" "+(int) chh);
        IO.println((char)(ch + 25)+" "+(int)(ch + 25));
        IO.println((char)(chh + 25)+" "+(int)(chh + 25));
    }
}