package ua.org.oracle.academy.malahk.Solution2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Admin on 10.07.2015.
 */
public class Writer2 extends Thread
{
    private BufferedWriter writer;

    public Writer2(File file)
    {
        this.start();

        try {
            this.writer = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close()
    {
        try {
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void push(Character c)
    {
        try {
            this.writer.append(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
