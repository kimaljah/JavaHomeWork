package HomeWork5;

import java.util.Arrays;

/*
 * Реализовать алгоритм пирамидальной сортировки (HeapSort).
 */

 public class hw05_3 {

    public static void main(String[] args) {
        int[] A = { 1, 45, 3, 10, 12, 6 };

        heapsort(A);

        System.out.println(Arrays.toString(A));
    }
 
     public static int LEFT(int i) {
         return (2 * i + 1);
     }
 
     public static int RIGHT(int i) {
         return (2 * i + 2);
     }
 
     public static void swap(int[] A, int i, int j) {
         int temp = A[i];
         A[i] = A[j];
         A[j] = temp;
     }
 
     public static void heapify(int[] A, int i, int size) {
 
         int left = LEFT(i);
         int right = RIGHT(i);
 
         int largest = i;
 
         if (left < size && A[left] > A[i]) {
             largest = left;
         }
 
         if (right < size && A[right] > A[largest]) {
             largest = right;
         }
 
         if (largest != i) {
             swap(A, i, largest);
             heapify(A, largest, size);
         }
     }
 
     public static int pop(int[] A, int size) {
 
         if (size <= 0) {
             return -1;
         }
 
         int top = A[0];
 
         A[0] = A[size - 1];
 
         heapify(A, 0, size - 1);
 
         return top;
     }
 
     public static void heapsort(int[] A) {
 
         int n = A.length;
 
         int i = (n - 2) / 2;
         while (i >= 0) {
             heapify(A, i--, n);
         }
 
         while (n > 0) {
             A[n - 1] = pop(A, n);
             n--;
         }
     }
 
   
 }