class test13 implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                IO.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                IO.println(e);
                ;
            }
            IO.println("run is over");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        test13 t = new test13();
        Thread t1 = new Thread(t, "Tamo Thread");
        // t1.setName("Tamo Thread");
        t1.start();

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            IO.println(Thread.currentThread().getName());
        }
        IO.println(Thread.currentThread().getName() + " ended...");
    }
}

class Alada {
    public static void main(String[] args) {
        Runnable r = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                    IO.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    IO.println(e);
                    ;
                }
                IO.println(Thread.currentThread().getName() + " ended...");
            }
        };
        Thread t1 = new Thread(r, "Tamooo");
        t1.start();
    }
}