class Test{
    void main(){
        // for(;;){
        //     IO.println("OS name: "+System.getProperty("os.name"));
        // }
        Thread t = Thread.currentThread();
        IO.println(t.getName());
        t.setName("TAMO");
        IO.println(t.getName());
        IO.println(t.threadId());
        // try{
        //     Thread.sleep(2000);
        // }catch(InterruptedException e){
        //     IO.println(e);
        // }
        IO.println(Thread.MAX_PRIORITY);
        IO.println(Thread.NORM_PRIORITY);
        IO.println(Thread.MIN_PRIORITY);
        IO.println(t.getPriority());

        t.setPriority(t.getPriority()+2);
        IO.println(t.getPriority());
    }
}