package ua.org.oracle.academy.malahk.Solution2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Admin on 07.07.2015.
 */
public class Writer extends Thread {

    public static final String DIRECTORY_NAME = "C:\\Users\\Admin\\workspace_idea\\DirectoryMess\\";

    @Override
    public void run() {
        LinkedListQueue queue = new LinkedListQueue();
        File file = new File(String.format("%s\\READER.txt", DIRECTORY_NAME));
        Writer2 writer = new Writer2(file);

        for (int i = 0; i < 10; ++i) {
            File file_r = new File(String.format("%s%d\\%d.txt", DIRECTORY_NAME, i, i));
            Reader reader = new Reader(file_r, writer);
            reader.start();
        }

        int i = 10 * 100 * 100;

//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
//            while (i > 0) {
//                if (queue.isEmpty()) {
//                    try {
//                        sleep(10);
//                        continue;
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        return;
//                    }
//                }
//
//                writer.append(queue.pull());
//                --i;
//            }
            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
