package others;

//sorting array O(nlog(n))
// quick select O(n)
public class NthSmallestHighest {

    public static void main(String[] args) {
        int[] input = {4, 5, 10, 11, 1, 3, 19, 8, 7};
        final int kthSmallestElement = findKthSmallestElement(input, 6, 0, input.length - 1);
        System.out.println(kthSmallestElement);
    }

    private static int findKthSmallestElement(int[] arr, int i, int low, int high) {
        int pivotPoint = getPivotPoint(arr, low, high);
        if (pivotPoint == i - 1) {
            return arr[pivotPoint];
        } else if (pivotPoint < i - 1) {
            return findKthSmallestElement(arr, i, pivotPoint + 1, high);
        } else {
            return findKthSmallestElement(arr, i, low, pivotPoint - 1);
        }
    }

    private static int getPivotPoint(int[] arr, int low, int high) {
        int pivotElement = arr[high];
        int pivotPoint = low;

        for (int i = low; i <= high; i++) {
            if (arr[i] < pivotElement) {
                int tmp = arr[i];
                arr[i] = arr[pivotPoint];
                arr[pivotPoint] = tmp;
                pivotPoint++;
            }
        }
        int tmp = arr[pivotPoint];
        arr[pivotPoint] = arr[high];
        arr[high] = tmp;
        
        return pivotPoint;
    }
}



