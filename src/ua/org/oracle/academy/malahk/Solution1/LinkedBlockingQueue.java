package ua.org.oracle.academy.malahk.Solution1;

import ua.org.oracle.academy.malahk.DirectoryMess;
import ua.org.oracle.academy.malahk.IOStreamsUtils;

import java.io.File;

/**
 * Created by Admin on 04.07.2015.
 */
public class LinkedBlockingQueue {

    private static java.util.concurrent.LinkedBlockingQueue<DirectoryMess> lbq = new java.util.concurrent.LinkedBlockingQueue<>();
    public static final String DIRECTORY_NAME = "C:\\Users\\Admin\\workspace_idea\\DirectoryMess\\";


    public class addToQueue implements Runnable {


        @Override
        public void run() {

            try {
                File file;
                int i = 0;
                while(i < 10){
                    file = new File(String.format("%s%d\\%d.txt", DIRECTORY_NAME, i, i));
                    lbq.put(new DirectoryMess(file));
                    System.out.printf("%s%d added.%n", file.getName(), i);
                    i++;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public class deleteFromQueue implements Runnable {


        @Override
        public void run () {
            DirectoryMess dm;
            IOStreamsUtils ios;
            try {
                int i = 0;
                while(i < 10){
                    dm = lbq.take();
                    dm.run();
                    System.out.printf("%d removed.%n", i);
                    i++;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
