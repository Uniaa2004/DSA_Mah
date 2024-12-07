package Algorithm;

import java.util.Arrays;

public class megeSort {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int n = 10000;
        int[] test = new int[n];
        for(int i = 1; i < test.length; i++) {
            test[i] = (int)(Math.random() * 10000);
        }
        mergeS(test);
        System.out.println(Arrays.toString(test));
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print(estimatedTime);
    }

    public static void mergeS(int[] arr) {
        // De quy
        // Basecase
        if(arr.length < 2) {
            return;
        }
        int[] left = Arrays.copyOfRange(arr, 0, arr.length/2);
        int[] right = Arrays.copyOfRange(arr, arr.length/2, arr.length);
        mergeS(left);
        mergeS(right);
        mergeS(arr, left, right);
    }

    public static void mergeS(int [] arr, int [] left, int [] right) {
        int indexLeft = 0;
        int indexRight = 0;

        for(int i = 0; i < arr.length; i++) {
            if (indexLeft >= left.length || (indexRight < right.length && left[indexLeft] > right[indexRight])) {
                arr[i] = right[indexRight];
                indexRight++;
            } else {
                arr [i] = left[indexLeft];
                indexLeft++;
            }
        }
    }

}