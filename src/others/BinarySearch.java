package others;

public class BinarySearch {
    int binarySearch(int arr[], int l, int r, int x) {
        if(r >= l) {
            int mid = l + (r - 1)/2;

            if(arr[mid] == x) return mid;
            if(arr[mid] > x) binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }
}
