package codewars.linkedlist;

import java.util.ArrayList;

import static codewars.linkedlist.LinkedList.*;

public class LoopInspector {

    public int loopSize(Node node) {
        ArrayList<Node> nodes = new ArrayList<>();

        while (!nodes.contains(node)) {
            nodes.add(node);
            node = node.getNext();
        }

        return nodes.size() - nodes.indexOf(node);
    }
}

// https://www.codewars.com/kata/52a89c2ea8ddc5547a000863/train/java