public class Main {
    public static void main(String[] args) {
        // 1. Create two instances of the Bag class
        LinkedFrequencyBag<String> lFBag1 = new LinkedFrequencyBag<>();
        LinkedFrequencyBag<String> lFBag2 = new LinkedFrequencyBag<>();
        // 2. Add Elements to each bag, including duplicates
          //bag1
        lFBag1.add("Strawberries", 9);
        lFBag1.add("blueberries", 5);
        lFBag1.add("Watermellon");
          //bag2
        lFBag2.add("Strawberries", 11);
        lFBag2.add("chocolate", 5);
        lFBag2.add("Apple");
        // 3. Print the size of each bag using the size method
        System.out.printf("Bag 1 contains %d elements %nBag 2 Contains %d elements%n", lFBag1.size(), lFBag2.size());
        //4. Merge the two bags together using the merge method
        lFBag1.merge(lFBag2);
        //5. print the merged bag contents
        System.out.print("After merging the two bags, ");
        lFBag1.printbag();
        //6. Create  a new bag containing only distinct elements using the distinct method
        LinkedFrequencyBag<String> distinctBag = lFBag1.distinct();
        //7. Print the distinct bag contents
        System.out.print("After creating a bag with distinct values from the merged bag, ");
        distinctBag.printbag();
        // additional test cases
          //attempt to add negative values
        System.out.println("Testing adding negative values to the bag:");
        lFBag1.add("strawberry", -2);
          //attempt to add 0 of an item
        System.out.println("Testing adding 0 quantity to the bag:");
        lFBag1.add("Strawberry", 0);
          //Use Uppercase
        System.out.println("Testing count method with upper case:");
        System.out.println(lFBag1.getCount("STRAWBERRIES"));
    }
}