package ua.org.oracle.academy.malahk.Solution2;

import java.io.*;

/**
 * Created by Admin on 07.07.2015.
 */
public class Reader extends Thread {
    private File file;
    private LinkedListQueue queue;
    private Writer2 writer;

    public Reader (File file, LinkedListQueue queue) {
        this.file = file;
        this.queue = queue;
    }

    public Reader (File file, Writer2 writer) {
        this.file = file;
        this.writer = writer;
    }

    @Override
    public void run() {
        try (BufferedReader myReader = new BufferedReader(new FileReader(this.file))) {
            for (int i = 0; i < 100; ++i) {
                String line = myReader.readLine();

                for (int j = 0; j < line.length(); ++j) {
                    this.push(line.charAt(j));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void push(Character c)
    {
        if (this.writer != null) {
            this.writer.push(c);
        } else {
            this.queue.push(c);
        }
    }
}
