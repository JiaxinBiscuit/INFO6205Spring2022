import java.util.HashSet;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){return null;}

        HashSet<Integer> set1 = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }

        HashSet<Integer> set2 = new HashSet<>();
        for(int i = 0; i < nums2.length; i++){
            set2.add(nums2[i]);
        }

        set1.retainAll(set2);

        int[] array = new int[set1.size()];
        int i = 0;
        for(Integer n : set1){
            array[i] = n;
            i++;
        }

        return array;

    }
}
