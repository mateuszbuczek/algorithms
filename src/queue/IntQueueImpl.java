package src.queue;

import java.util.ArrayList;
import java.util.List;

public class IntQueueImpl implements IntQueue {

    private List<Integer> data;

    private int p_start;

    public IntQueueImpl() {
        data = new ArrayList<>();
        p_start = 0;
    }

    @Override
    public boolean enQueue(int x) {
        data.add(x);
        return true;
    }

    @Override
    public boolean deQueue() {
        if(isEmpty() == true) return false;
        p_start++;
        return true;
    }

    @Override
    public int Front() {
        return data.get(p_start);
    }

    @Override
    public boolean isEmpty() {
        return p_start >= data.size();
    }
}
