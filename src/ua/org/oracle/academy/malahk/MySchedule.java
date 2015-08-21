package ua.org.oracle.academy.malahk;

/**
 * Created by Admin on 30.06.2015.
 */
public class MySchedule implements Runnable {

    private Integer i;
    private String s;

    public MySchedule(Integer i, String s) {
        this.i = i;
        this.s = s;
    }

    @Override
    public void run() {

        while (true) {

            System.out.println(s);

            try {

                Thread.sleep(i);

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }

    }
}
