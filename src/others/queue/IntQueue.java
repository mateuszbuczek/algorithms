package src.queue;

import java.util.List;

public interface IntQueue {

    public boolean enQueue(int x);

    public boolean deQueue();

    public int Front();

    public boolean isEmpty();
}
