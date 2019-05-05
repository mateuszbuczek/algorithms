package src.stack;

import java.util.ArrayList;
import java.util.List;

public class IntStackImpl implements IntStack {

    private List<Integer> data;

    public IntStackImpl() {
        data = new ArrayList<>();
    }

    @Override
    public void push(int x) {
        data.add(x);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int top() {
        return data.get(data.size() -1);
    }

    @Override
    public boolean pop() {
        if(isEmpty()) return false;
        data.remove(data.size() - 1);
        return true;
    }
}
