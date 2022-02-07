public class FindMinimumInRotatedSortedArray{

    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length-1;
        int mid = 0;

        while(left+1 < right){
            mid = left + (right-left)/2;
            if(nums[mid] < nums[right]){
                right = mid;
            } else{
                left = mid;
            }
        }

        return nums[right] < nums[left]? right:left;
    }

}
