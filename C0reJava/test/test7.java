class test7 {
    public static void main(String[] args) {
        //for(;;)
        System.out.println("JAVA version "+System.getProperty("java.version"));
        var i=10;
        var d=10.0;
        var s="hi";
        // var s=true;
        // var t;
        int x;

        for(var j=0; j<10; j++){
            System.out.println(demo(j));
        }
    }
    static float demo(int x){
        var f = x;
        return f;
    }
}
