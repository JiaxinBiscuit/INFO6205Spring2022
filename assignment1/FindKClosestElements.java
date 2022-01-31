import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length == 0){return null;}

        int pivot = findPivot(arr,x);
        int prev = pivot -1;
        int next = pivot +1;

        List<Integer> res = new ArrayList<>();
        res.add(arr[pivot]);
        k--;

        while(k > 0 && prev >= 0 && next <= arr.length - 1){
            if (Math.abs(arr[prev]-x) < Math.abs(arr[next]-x) || (Math.abs(arr[prev]-x) == Math.abs(arr[next]-x) && arr[prev] < arr[next])){
                res.add(arr[prev]);
                prev--;
            } else {
                res.add(arr[next]);
                next++;
            }
            k--;
        }

        while (k > 0) {
            if (prev >= 0) {
                res.add(arr[prev]);
                prev--;
            } else if (next <= arr.length - 1) {
                res.add(arr[next]);
                next++;
            } else {
                break;
            }
            k--;
        }
        Collections.sort(res);
        return res;
    }

    private int findPivot(int[] arr, int x){
        int left = 0;
        int right = arr.length-1;

        while(left+1 < right){
            int mid = left + (right-left)/2;
            if (arr[mid] == x){
                return mid;
            } else if (arr[mid] > x){
                right--;
            } else {
                left++;
            }
        }

        return ((Math.abs(arr[left]-x) < Math.abs(arr[right]-x) || (Math.abs(arr[left]-x) == Math.abs(arr[right]-x) && arr[left] < arr[right])))? left:right;
    }
}
