import java.util.Random;

public class Main {
    private static class SortResults {
        int size;
        long selectionTime, mergeTime;
        public SortResults(int size, long sel, long merg) {
            this.size = size;
            this.selectionTime = sel;
            this.mergeTime = merg;
        }
    }
    private static int[] randomIntArray(int n) {
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            // populate array with random int between 0 and 100
            array[i] = random.nextInt(100);
        }
        return array;
    }
    private static SortResults sortCompare(int exp) {
        int size = (int) Math.pow(2, exp);
        int[] originalArray = randomIntArray(size);
        int[] selectionCopy = originalArray.clone();
        int[] mergeCopy = originalArray.clone();

        long startTime = System.nanoTime(); //start timer
        Sort.selection(selectionCopy);
        long endTime = System.nanoTime(); //end timer
        long selectionTime = endTime - startTime; //calculate time

        startTime = System.nanoTime(); //restart timer
        Sort.mergeSort(mergeCopy);
        endTime = System.nanoTime(); //end timer
        long mergeTime = endTime - startTime; //calculate time

        return new SortResults(size, selectionTime, mergeTime);
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {sortCompare(3);} // warmup laps
        String winner;
        System.out.printf("%-12s %-22s %-22s %-22s", "Array Size"
                , "Selection Sort (ns)", "Merge Sort (ns)", "Winner");
        System.out.println("\n------------------------------------------------------------------------");
        for (int exp = 1; exp < 11; exp++) {
            SortResults results = sortCompare(exp);
            if(results.selectionTime < results.mergeTime) {winner = "Selection";}
            else {winner = "Merge";}
            System.out.printf("%-12d %-22d %-22d %-22s%n"
               , results.size, results.selectionTime, results.mergeTime, winner);
        }
    }
}