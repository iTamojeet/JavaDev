import java.util.*;
enum DTDC{
    CAR("Chennai"),TRUCK("Delhi"),TOTO(30),AUTO(25),VAN(20),TRAIN("Mumbai");
    private int speed;
    private String location;
    DTDC(){
        System.out.println("DTDC 0 args constructor");
    }
    DTDC(int speed){
        this.speed=speed;
    }

    public int getSpeed() {
        return this.speed;
    }

    DTDC(String location){
        this.location=location;
    }

    public String getLocation() {
        return this.location;
    }
    // private int i;
    // public int getI() {
    //     return i;
    // }

    // E(){
    //     System.out.println("in enum constructor");
    // }
    // E(int i){
    //     this.i=i;
    //     System.out.println("in enum constructor with value: " + i);
    // }
    // E(String s){
    //     System.out.println("in enum constructor with value: " + s);
    // }
    // E(double d, boolean b){
    //     System.out.println("in enum constructor with values: " + d + " and " + b);
    // }
}

class Get{
    public static void main(String[] args) {

        DTDC d;
        d=DTDC.TOTO;
        System.out.println(d);

        if(d==DTDC.TOTO){
            System.out.println("TOTO is selected");
        }

        System.out.print("enter media: ");
        Scanner sc=new Scanner(System.in);

        switch(DTDC.valueOf(sc.next())){
            case CAR-> System.out.println("Car is selected");
            case TRUCK-> System.out.println("Truck is selected");
            case TOTO-> System.out.println("Toto is selected");
            case AUTO-> System.out.println("Auto is selected");
            case VAN-> System.out.println("Van is selected");
            case TRAIN-> System.out.println("Train is selected");
            default-> System.out.println("Invalid selection");
        }

        System.out.println("-".repeat(60));

        for(DTDC dc : DTDC.values()){
            System.out.println(dc + " has speed: " + dc.getSpeed() + " and goes to location: " + dc.getLocation());
        }
        // E e;
        // e=E.C;
        // System.out.println(e.getI());

        // E []r=E.values();
        // for(E ee:r){
        //     System.out.println(ee + " has value: " + ee.getI());
        // }
    }
}