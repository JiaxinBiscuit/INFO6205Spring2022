public class SortArrayByIncreasingFrequency {

    public int[] frequencySort(int[] nums) {

        int[] arr = new int[201];


        for(int n: nums){
            arr[n+100]++;
        }

        int count = 0;
        for(int n: arr){
            if(n != 0){
                count = count + n;
            }
        }


        int[] res = new int[count];
        int index = 0;


        for(int i = 1; i <= 100; i++){
            for(int j = arr.length-1; j >= 0; j--){
                if( arr[j] == i){
                    for(int k = 0; k < i; k++){
                        res[index] = j-100;
                        index++;
                    }
                }
            }
        }



        return res;

    }

}
