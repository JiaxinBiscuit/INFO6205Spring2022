import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    int[] nums;

    public MajorityElementII(int[] array){
        nums = array;
    }

    public List<Integer> majorityElement() {
        if(nums == null || nums.length == 0 ){return null;}

        int count1 = 0;
        int count2 = 0;

        Integer candidate1 = null;
        Integer candidate2 = null;

        for(int n : nums){
            if (candidate1 != null && candidate1 == n){
                count1++;
            } else if (candidate2 != null && candidate2 == n){
                count2++;
            } else if (count1 == 0){
                candidate1 = n;
                count1++;
            } else if (count2 == 0){
                candidate2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        List result = new ArrayList<>();

        count1 = 0;
        count2 = 0;

        for(int n:nums){
            if (candidate1 != null && n == candidate1 ) count1++;
            if (candidate2 != null && n == candidate2) count2++;
        }

        if(count1 > nums.length/3){result.add(candidate1);}
        if(count2 > nums.length/3){result.add(candidate2);}

        return result;

    }
}
