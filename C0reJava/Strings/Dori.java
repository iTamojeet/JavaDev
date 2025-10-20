void main(){
    String a = "Tamo";
    String b = "Tamo";

    IO.println(a == b);
    IO.println(a.equals(b));
    IO.println("-".repeat(60));

    a = new String("Tamo");
    b = new String("Tamo");

    IO.println(a == b);
    IO.println(a.equals(b));
    IO.println("-".repeat(60));
}