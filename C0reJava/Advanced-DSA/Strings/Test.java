void main(){
    int x = 127;
    int y = 127;
    IO.println(x == y);

    Integer i = 127;
    Integer j = 127;
    IO.println(i == j);

    Integer ___ = 128;
    Integer __ = 128;
    IO.println(___ == __); // false
    IO.println(___.equals(__));

    var ____ = 128;
    var _____ = 128;
    IO.println(____ == _____);
}