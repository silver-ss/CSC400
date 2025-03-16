public class RadixSort {
    // find and return maximum value in array
    private static int findMax(int[] array) {
        int max = array[0];
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
    // sorts array by values in the exponent(e) position
    private static void countSort(int[] array, int n, int e) {
        int[] newArray = new int[n];
        int i;
        int count[] = new int[10];
        // find the digit at exponent, e, from each element in array
        // increment value of that index in count array to tally digits 0-9
        // ex. array[1] = 803, e = 1, increment count[3]
        for (i = 0; i < n; i++) {
            count[(array[i] / e) % 10]++;
        }

        // convert array to cumulative sum of values in count
        for (i = 1; i < 10; i++) {
            count[i] += count[i-1];
        }
        // create sorted array
        for (i = (n-1); i >= 0; i--) {
            // starting at end of array get the digit at exponent, e, from each element in array (array[i] / e) % 10
            // use the cumulative count array to find which index that value should go when sorted
            // the index where the value should go when sorted is count[digit -1] since array is 0 indexed
            // set element from array to that index in newArray
            newArray[count[(array[i] / e) % 10] -1 ] = array[i];
            // decrement the previously used index in count array to assign
            // next element with the same value to previous index in newArray
            count[(array[i] / e) % 10]--;

        }
        //update provided array to match the sorted version, newArray
        for (i = 0; i < n; i++) {
            array[i] = newArray[i];
        }
    }
    // finds max, loops through countSort (number of digits in max) times
    public void radix(int[] array, int n) {
        int max = findMax(array);
        //run countSort for number of digits in max value
        //each iteration multiply e by 10 until larger than max
        for (int e = 1; max / e > 0; e *=10) {
            countSort(array, n, e);
            System.out.println("Array after iteration for e = " + e +":");
            for (int i = 0; i < n; i++) {
                if (i == (n-1)) { System.out.println(array[i]); }
                else { System.out.print(array[i] +", "); }
            }
        }
    }
}