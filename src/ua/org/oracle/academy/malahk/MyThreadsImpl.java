package ua.org.oracle.academy.malahk;

/**
 * Created by Admin on 26.06.2015.
 */
public class MyThreadsImpl implements Runnable {

    @Override
    public void run () {

        for(int i = 0; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }
}
