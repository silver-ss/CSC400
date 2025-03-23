import java.util.Iterator;

public class Main {
    private static void printList(CustomLinkedList linkedList) {
        Iterator<Integer> iterator = linkedList.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
    private static void deleteFromlist(CustomLinkedList linkedList, int value) {
        int deleted = linkedList.delete(value);
        if (deleted != -1) { System.out.println("Deleted: " + deleted); }
        else { System.out.println("Item to be deleted not found: " + value); }
        System.out.println("LinkedList after deletion:");
        printList(linkedList);
    }
    public static void main(String[] args) {
        String path = "C:\\Users\\smsav\\OneDrive\\Desktop\\listContent.txt";
        //content in file 5,4,3,2,1,a,4
        //make list from file
        CustomLinkedList linkedList = ListFromFile.createList(path);
        //show list
        System.out.println("Initial list:");
        printList(linkedList);
        // test delete with valid entry
        deleteFromlist(linkedList, 4);
        // test delete with invalid entry
        deleteFromlist(linkedList, 7);
        // test insert valid integer value
        linkedList.insert(7);
        printList(linkedList);
        //test insert non-integer value
        linkedList.insert('b');
        printList(linkedList);
    }
}