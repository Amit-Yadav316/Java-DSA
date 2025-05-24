package BinarySearching;

public class MountainArrayBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1};
        int target = 6;
        int result = binarySearch(arr, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
    public static int binarySearch(int[] arr, int target) {
        int peak = findPeak(arr);
        int leftSearch = binarySearch(arr, 0, peak, target);
        if (leftSearch != -1) {
            return leftSearch;
        }
        return binarySearch(arr, peak + 1, arr.length - 1, target);
    }
    public static int binarySearch(int[] arr, int start, int end, int target) {
        boolean isAsc = arr[start] < arr[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (isAsc) {
                if (arr[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (arr[mid] > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
    public static int findPeak(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid; 
            } else {
                start = mid + 1; 
            }
        }
        return start;
    }
}
