void main(){
    String a = "Tamo";
    String b = "Tamo";

    IO.println(a == b);
    IO.println(a.equals(b));
    IO.println("-".repeat(60));

    a = new String("Tamo");
    b = new String("Tamo");

    IO.println(a == b); // false
    IO.println(a.equals(b));
    IO.println("-".repeat(60));

    System.out.printf("PI: %.5f\n", Math.PI);
    IO.println("-".repeat(60));

    IO.println('a'*1);
    IO.println('A'*1);
    IO.println((char)('a'+25));
    IO.println((char)('A'+25));
    IO.println("-".repeat(60));

    // int will be converted to Integer that will call toString()
    // this is same as after a few steps: "A" + "999"
    IO.println("A" + 999);
}