package codewars.linkedlist;

class LinkedList {

    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {data = d;}
    }

    static LinkedList insert(LinkedList list, int data) {
        Node newNode = new Node(data);

        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;

            while (last.next != null) {
                last = last.next;
            }

            last.next = newNode;
        }

        return list;
    }

    static void printList(LinkedList list) {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        while (currNode != null) {
            System.out.print(currNode.data + " ");

            currNode = currNode.next;
        }
    }

    static LinkedList deleteByKey(LinkedList list, int key) {
        Node currNode = list.head;
        Node prev = null;

        {
            if (currNode != null && currNode.data == key) {
                list.head = currNode.next;
                return list;
            }
        }

        {
            while (currNode != null && currNode.data != key) {
                prev = currNode;
                currNode = currNode.next;
            }

            if (currNode != null) {
                prev.next = currNode.next;

                System.out.print(key + " found in list and deleted");
            }

            if (currNode == null) {
                System.out.print(key + " was not found");
            }
        }
        return list;
    }

    static LinkedList deleteAtPosition(LinkedList list, int index) {
        Node currNode = list.head;
        Node prev = null;

        {
            if (index == 0 && currNode != null) {
                list.head = currNode.next;
                System.out.println(index + " position element deleted");

                return list;
            }
        }

        {
            int counter = 0;

            while (currNode != null) {
                if (counter == index) {
                    prev.next = currNode.next;
                    System.out.println(index + " position element deleted");
                    break;
                } else {
                    prev = currNode;
                    currNode = currNode.next;
                    counter++;
                }
            }


            if (currNode == null) {
                System.out.println(index + " position was not found");
            }
        }
        return list;
    }
}
