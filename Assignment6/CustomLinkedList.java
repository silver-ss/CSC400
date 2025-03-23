import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedList  {
    private Node head;
    private Node tail;
    private int size;
//Create custom iterator
    public Iterator<Integer> iterator() {
        return new LinkedListIterator();
    }
//Constructor
    public CustomLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
//Insert Method
    public void insert(Object data) {
        // Check if data passed is an int if not, dont insert
        if (! (data instanceof Integer)) {
            System.out.println("Invalid entry: " + data + " is not an integer, Skipping Insert");
            return;
        }
        //convert data to int
        Integer intData = (Integer) data;
        //set new node to head & tail if no items in list yet
        if (head == null) {
            head = new Node(intData);
            tail = head;
            size++;
        }
        else {
            //insert at end of list and update tail ref
            tail.next = new Node(intData);
            tail = tail.next;
            size++;
        }
    }
//Delete first occurrence of matching int
    public int delete(int data) {
        //for empty list return -1
        if (head == null) { return -1; }
        //if head is a match replace head with next
        if (head.data == data) {
            head = head.next;
            size--;
            // if list size was 1 and now 0, set tail to null
            if(head == null) { tail = null; }
            return data;
        }
        Node previous = head;
        Node current = head.next;
        // iterate through the rest of the list to find matching int
        while (current != null) {
            // if match found remove node, update pointers
            if(current.data == data) {
                previous.next = current.next;
                size--;
                //update tail if tail is the first match
                if (tail == current) {
                    tail = previous;
                }
                return current.data;
            }
            previous = current;
            current = current.next;
        }
        // not found return -1
        return -1;
    }
//Private class for nodes
    private class Node {
        Integer data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
//Private class iterator
    private class LinkedListIterator implements Iterator<Integer> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int data = current.data;
            current = current.next;
            return data;
        }
    }
}