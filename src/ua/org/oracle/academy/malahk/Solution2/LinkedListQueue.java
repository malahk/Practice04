package ua.org.oracle.academy.malahk.Solution2;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Admin on 07.07.2015.
 */
public class LinkedListQueue {

    List<Character> queue = new LinkedList<>();

    public void push (Character c) {
        this.queue.add(c);
    }

    public char pull () {
        return this.queue.remove(0);
//        return this.queue.poll();
//        return this.queue.size() + " ";
    }

    public boolean isEmpty () {
        return this.queue.isEmpty();
    }
}
