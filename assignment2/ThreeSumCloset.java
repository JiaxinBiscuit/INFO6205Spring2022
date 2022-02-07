import java.util.Arrays;

public class ThreeSumCloset {

    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3){
            return -1;
        }

        int cur = 0;
        int left = 1;
        int right = nums.length-1;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int sum = 0;

        while(cur < nums.length -1){
            if(diff == 0){
                return target;
            }else {
                while(left<right){
                    sum = nums[cur] + nums[left] + nums[right];
                    if(Math.abs(target-sum)< Math.abs(diff)){
                        diff = target-sum;
                    }
                    if(sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
            cur++;
            left = cur+1;
            right = nums.length-1;
        }

        return target-diff;
    }


}
