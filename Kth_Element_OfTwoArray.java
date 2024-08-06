// Given two sorted arrays arr1 and arr2 and an element k. The task is to find the element that would be at the kth position of the combined sorted array.



public class Kth_Element_OfTwoArray {

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};
        int k = 5;

        System.out.println("The element at the " + k + "th position is: " + findKthElement(arr1, arr2, k));
    }

    public static int findKthElement(int[] arr1, int[] arr2, int k) {
        return findKthElementHelper(arr1, arr2, 0, 0, k);
    }

    private static int findKthElementHelper(int[] arr1, int[] arr2, int start1, int start2, int k) {
        if (start1 >= arr1.length) {
            return arr2[start2 + k - 1];
        }
        if (start2 >= arr2.length) {
            return arr1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(arr1[start1], arr2[start2]);
        }

        int mid1 = start1 + k / 2 - 1;
        int mid2 = start2 + k / 2 - 1;

        int val1 = (mid1 < arr1.length) ? arr1[mid1] : Integer.MAX_VALUE;
        int val2 = (mid2 < arr2.length) ? arr2[mid2] : Integer.MAX_VALUE;

        if (val1 < val2) {
            return findKthElementHelper(arr1, arr2, mid1 + 1, start2, k - k / 2);
        } else {
            return findKthElementHelper(arr1, arr2, start1, mid2 + 1, k - k / 2);
        }
    }
}