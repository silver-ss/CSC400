//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // 1. Create two instances of the Bag class
        Bag<String> bag1 = new Bag<>();
        Bag<String> bag2 = new Bag<>();
        // 2. Add Elements to each bag, including duplicates
          //bag1
        bag1.add("Strawberries", 9);
        bag1.add("blueberries", 5);
        bag1.add("Watermellon");
          //bag2
        bag2.add("Strawberries", 11);
        bag2.add("chocolate", 5);
        bag2.add("Apple");
        // 3. Print the size of each bag using the size method
        System.out.printf("Bag 1 contains %d elements %nBag 2 Contains %d elements%n", bag1.size(), bag2.size());
        //4. Merge the two bags together using the merge method
        bag1.merge(bag2);
        //5. print the merged bag contents
        System.out.print("Afer merging the two bags, ");
        bag1.printbag();
        //6. Create  a new bag containing only distinct elements using the distinct method
        Bag<String> distinctBag = bag1.distinct();
        //7. Print the distinct bag contents
        System.out.print("Afer Create a bag with distinct values from the merged bag, ");
        distinctBag.printbag();
        // additional test cases
          //attempt to add negative values
        System.out.println("Testing adding negative values to the bag:");
        bag1.add("strawberry", -2);
          //attempt to add 0 of an item
        System.out.println("Testing adding 0 quantity to the bag:");
        bag1.add("Strawberry", 0);
          //Use Uppercase
        System.out.println("Testing count method with upper case:");
        System.out.println(bag1.getCount("STRAWBERRIES"));

    }
}