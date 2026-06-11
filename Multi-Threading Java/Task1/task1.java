package Task1;
class Thread1 extends Thread {
    @Override
    public synchronized void run() {
        for (int i=0;i<10;i++) {
            System.out.println(i+1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }
}
class Thread2 extends Thread {
    Thread t1 = new Thread();
    Thread2(Thread t1) {
        this.t1 = t1;
    }
    @Override
    public synchronized void run() {
        try {
            // Join ka kaam hain ki pichle thread ke khatam hone ke baad hi tum usse join krna
            t1.join();
        } catch(InterruptedException exp) {
            System.out.println("Exception!!!!!");
        };
        System.out.println("Blast off!");
    }
}
class task1 {
    public static void main(String... args) throws InterruptedException{
        Thread t1 = new Thread1();
        // Jo parameter mein jaata hain uska refernce type same hona chahiye
        Thread t2 = new Thread2(t1);
        t1.start();
        t2.start();
    }
}