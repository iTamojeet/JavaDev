class MyThread extends Thread{

    MyThread(String name){
        super(name);
    }

    @Override
    public void run(){
        for(int i=0; i<7; i++){
            IO.println("Thread running is: "+Thread.currentThread().getName());
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                IO.println(e);
            }
        }
        IO.println("~~~ thread is finished: "+Thread.currentThread().getName());
    }
}