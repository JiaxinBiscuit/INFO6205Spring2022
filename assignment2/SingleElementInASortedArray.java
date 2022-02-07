public class SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        if(nums.length == 1){
            return nums[0];
        }


        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] == nums[mid+1]){
                if((right - mid +1) % 2 == 0){
                    right = mid-1;
                }else{
                    left = mid+2;
                }
            }else if(nums[mid-1] == nums[mid]){
                if((right - mid) % 2 == 0){
                    right = mid -2;
                }else{
                    left = mid+1;
                }
            } else return nums[mid];
        }

        return nums[left];
    }
}
