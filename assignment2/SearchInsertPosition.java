public class SearchInsertPosition {

    public int searchInsertPosition(int[] arr, int target){
        if(arr == null || arr.length == 0 ){
            return -1;
        }

        int left = 0;
        int right = arr.length -1;

        if(target <= arr[left]){return 0;}
        if(target > arr[right]){return right+1;}

        while(left+1 < right){
            int mid = left + (right-left)/2;
            if(target == arr[mid]){
                return mid;
            } else if (target < arr[mid]){
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;

    }



}
