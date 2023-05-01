package HomeWork3;

import java.util.Arrays;
import java.util.Random;

/**
 * 
 * Реализовать алгоритм сортировки слиянием
 * hw03_1
 */
public class hw03_1 {

    public static void main(String[] args) {
        int[] array1 = randomArr();
        int[] result = mergesort(array1);
        System.out.println(Arrays.toString(result));
    }

    public static int[] randomArr() {

        Random rand = new Random(0);
         int arr[] = new int[10];
         for (int i = 0; i < arr.length; i++)
        {
        arr[i] = rand.nextInt(100);
        System.out.print(arr[i] + " ");
        }
        System.out.println("");
        return arr;
    }

    public static int[] mergesort(int[] array1) {
        int[] right = Arrays.copyOf(array1, array1.length);
        int[] left = new int[array1.length];
        int[] result = mergesortInner(right, left, 0, array1.length);
        return result;
    }

    public static int[] mergesortInner(int[] right, int[] left,int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return right;
        }

        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sort1 = mergesortInner(right, left, startIndex, middle);
        int[] sort2 = mergesortInner(right, left, middle, endIndex);

        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sort1 == right ? left : right;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sort1[index1] < sort2[index2]
                    ? sort1[index1++]
                    : sort2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sort1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sort2[index2++];
        }
        return result;
    }
}