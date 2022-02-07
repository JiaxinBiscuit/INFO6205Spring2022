import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, int target, int start, int k){
        List<List<Integer>> res = new ArrayList<>();

        if(start == nums.length){
            return res;
        }

        int averageValue = target/k;

        if(nums[start] > averageValue || nums[nums.length-1] < averageValue){
            return res;
        }

        if(k == 2){
            return twoSum(nums, target, start);
        }

        for(int i = start; i<nums.length; i++){
            if (i == start || nums[i - 1] != nums[i]) {
                for(List<Integer> subset : kSum(nums, target-nums[i],i+1,k-1)){
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int start){
        List<List<Integer>> res = new ArrayList<>();
        HashSet set = new HashSet();

        for (int i = start; i < nums.length; i++) {
            if (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i]){
                int complement = target - nums[i];
                if (set.contains(complement)) {
                    res.add(Arrays.asList(complement, nums[i]));
                }
            }set.add(nums[i]);
        }
        return res;
    }

}
