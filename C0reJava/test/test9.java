@FunctionalInterface
interface Figure{
    void draw();
}
class Rectangle implements Figure{
    public void draw(){
        IO.println("Rectangle");
    }
}
class Square implements Figure{
    public void draw(){
        IO.println("Square");
    }
}
class Test9{
    void main(){
        call(()->new Rectangle().draw());
        call(()->new Square().draw());
        // Figure f = new Rectangle();
        // f.draw();
        // f=new Square();
        // f.draw();
    }
    static void call(Figure f){
        f.draw();
    }
}