public class Main {
    public static void main(String[] args) {
        //1. Create an instance of the bag class
        Bag<String> bag = new Bag<String>();
        //2. Add several elements to the bag including duplicates
          // using multi add
        bag.add("Apple", 10);
        bag.add("Orange", 12);
          //adding elements individually
        bag.add("Apple");
          //add duplicate elements individually
        bag.add("Grapes");
        bag.add("Grapes");
        //3. print the bag contents
        bag.printbag();
        //4. Test the contains elements
          //testing not case specific
        System.out.println("Orange is in the bag: " + bag.contains("orange"));
        System.out.println("Apple is in the bag: " + bag.contains("Apple"));
          //test item that is not in bag
        System.out.println("Bitcoin is in the bag: " + bag.contains("Bitcoin"));
        //5. test the count method for a few elements
        System.out.println("Apples in bag after adding eleven: " +
                bag.getCount("Apple"));
        System.out.println("Grapes in bag after adding two: " +
                bag.getCount("Grapes"));
        //6. remove an element
        bag.remove("Grapes");
        //7. Print the bag contents again to confirm there is now one Grapes in the bag
        bag.printbag();
        //8. Test contains method to ensure grapes still in list after removing 1 of the 2
        System.out.println("Grapes is still in the list after removing one of the two: "
            + bag.contains("grapes"));
          // Remove the final Grape element and check again should be false now.
        bag.remove("Grapes");
        System.out.println("Grapes is in the list after removing the last one: "
                + bag.contains("grapes"));
        //9. Test the count method for an item not in the list
        System.out.print("Grapes in the list now: " + bag.getCount("Grapes"));
    }
}