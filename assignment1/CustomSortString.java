public class CustomSortString {

    public String customSortString(String order, String s) {
        if(order == null || s == null){
            return null;
        }

        char[] arrS = s.toCharArray();

        int[] arr = new int[26];
        for(char c: arrS){
            arr[c-'a']++;
        }

        int count = 0;
        for(int n:arr){
            count = count+n;
        }

        char[] arrOrder = order.toCharArray();
        char[] res = new char[count];
        int index = 0;

        for(char c: arrOrder){
            if(arr[c-'a'] != 0){
                for(int k=0; k<arr[c-'a']; k++){
                    res[index] = c;
                    index++;
                }
                arr[c-'a'] = 0;
            }
        }


        for(int i = 0; i< arr.length; i++){
            if(arr[i] !=0){
                for(int k=0; k<arr[i]; k++){
                    res[index] = (char)(i+'a');
                    index++;
                }
            }
        }


        return String.valueOf(res);


    }
}
