import java.util.LinkedList;
import java.util.Set;
import java.util.LinkedHashSet;

public class Bag<T> {
    private LinkedList<T> bag;

    public Bag() {
        bag = new LinkedList<T>();
    }
    //if the item is a string lower case it
    private T lowerIfString(T element) {
        if (element instanceof String) {
            String lower = ((String) element).toLowerCase();
            return (T) lower;
        }
        //if not a string just return the element
        return element;
    }
    private boolean isPositive(int n) {
        if (n <= 0) {
            System.out.println("Please provide a positive integer to add multiple items");
            return false;
        }
        return true;

    }
    //single add
    public void add(T element) {
        bag.add(lowerIfString(element));
    }
    //method overloading to add multiple with additional parameter
    //how many of the specific element are to be added
    public void add(T element, int n) {
        if (!isPositive(n)) {
            return; //dont take action on negative values
        }
        for (int i = 0; i < n; i++) {
            add(element);
        }
    }
    //single remove items return false if  not in list
    public boolean remove(T element) {
        return bag.remove(lowerIfString(element));
    }
    //method overloading to remove multiple items
    // returns false if less elements were in list then removal request
    public boolean remove(T element, int n) {
        boolean status = false;
        if (!isPositive(n)) {
            return false; //dont remove if value is negative
        }
        for (int i = 0; i < n; i++) {
            status = remove(element);
        }
        return status;
    }
    // contains method returns true if at least 1 of the provided
    // element exist is in the list
    public boolean contains(T element){
        return bag.contains(lowerIfString(element));
    }
    //count instances of a specific item in bag
    public int getCount(T element) {
        int count = 0;
        for (T name : bag) {
            if (name.equals(lowerIfString(element))) {
                ++count;
            }
        }
        return count;
    }
    public Set<T> getDistinct() {
         return new LinkedHashSet<>(bag);
    }
    public void printbag() {
        int n = 1;
        //Header
        System.out.println("Contents of bag:");
        // loop through set, get counts, increment n to print list of items and counts
        for (T element : getDistinct()) {
            System.out.printf("Item %d: %-3d %s%n", n, getCount(element), element.toString());
            ++n;
        }
    }
    public int size() {
        return bag.size();
    }
    public void merge(Bag<T> otherBag) {
        // add the underlying elements from otherbag to bag
        bag.addAll(otherBag.bag);
    }
    public Bag<T> distinct() {
        Bag<T> distinctBag = new Bag<T>();
        for (T element : getDistinct()) {
            distinctBag.add(element);
        }
        return distinctBag;
    }
}