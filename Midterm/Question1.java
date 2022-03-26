import java.util.Arrays;
import java.util.HashSet;

public class Question1 {
    public String[] missingNumber(int lower, int upper, int[] nums) {
        if (lower > upper || nums == null || nums.length == 0) {
            return new String[0];
        }

        if (lower == upper && nums[0] == lower) {
            return new String[0];
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = lower; i <= upper; i++) {
            set.add(i);
        }

        for (int j = 0; j < nums.length; j++) {
            if (set.contains(nums[j])) {
                set.remove(nums[j]);
            }
        }

        int[] res = new int[upper - lower + 1];
        for (int k = 0; k < res.length; k++) {
            for (int i : set) {
                res[k] = i;
            }
        }

        Arrays.sort(res);
        String[] output = new String[upper - lower + 1];


        int k = 0;
        for (int j = 0; j < res.length; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (res[j] > nums[i]) {
                    i++;
                }
                int[] range = new int[2];
                range[0] = res[j];
                while (res[j] < nums[i]) {
                    j++;
                }
                range[1] = res[j-1];
                if (range[1] == range[2]) {
                    output[k++] = "ange[1]";
                } else {
                    output[k++] = "nums[i]+1 -> res[j]";
                }
            }
        }

        return output;
    }
}

