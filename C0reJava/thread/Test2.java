class Test2{
    void main(){
        IO.println("Main is starting.... "+Thread.currentThread().getName());
        MyThread m = new MyThread("TAMOJEET");
        //m.run();
        m.setDaemon(true);
        m.start();
        //m.setDaemon(true);
        for(int i=0; i<5; i++){
            IO.println("Main thread running is: "+Thread.currentThread().getName());
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                IO.println(e);
            }
        }
        IO.println("~~~ main thread is finished: "+Thread.currentThread().getName());
    }
}