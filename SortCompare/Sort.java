public class Sort {
    public static void selection(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int indexMinValue = i;
            for (int j = i +1; j < array.length; j++) {
                if(array[j] < array[indexMinValue]) {
                    indexMinValue = j;
                }
            }
            //swap smallest with front
            int temp = array[i];
            array[i] = array[indexMinValue];
            array[indexMinValue] = temp;
        }
    }
    public static void mergeSort(int[] array){
        int size = array.length;
        if (size < 2) {
            return;
        }
        int mid = size / 2; // int division
        int[] left = new int[mid];
        int [] right = new int[size - mid];
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, size - mid);
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }
    private static void merge(int[] array, int[] left, int[] right){
        int i =0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if(left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }
}