//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Test {
    public static void main(String[] args) {
        int [] array = new int[]{783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};
        int n = array.length;
        RadixSort Rsort = new RadixSort();
        System.out.println("Initial Array:");
        for (int i =0; i < n; i++) {
            if (i < (n-1)) { System.out.print(i + ", "); }
            else { System.out.println(i); }
        }
        Rsort.radix(array, n);
    }
}

/* Output:
Initial Array:
0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
Array after iteration for e = 1:
491, 472, 182, 692, 783, 543, 264, 94, 295, 356, 99
Array after iteration for e = 10:
543, 356, 264, 472, 182, 783, 491, 692, 94, 295, 99
Array after iteration for e = 100:
94, 99, 182, 264, 295, 356, 472, 491, 543, 692, 783
*/