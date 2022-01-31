public class SortColors {
    int[] nums;

    public SortColors(int[] array){
        this.nums =array;
    }
    public void sortColors() {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] != 2) {
                left++;
            } else if (nums[right] == 2) {
                right--;
            } else {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        right = nums.length - 1;
        while (right >= 0) {
            if (nums[right] == 2) {
                right--;
            } else break;
        }

        left = 0;
        while (left < right) {
            if (nums[left] == 0) {
                left++;
            } else if (nums[right] == 1) {
                right--;
            } else {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
    }

        private void swap(int[] array, int i, int j){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

}
