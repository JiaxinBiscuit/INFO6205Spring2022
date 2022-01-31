import java.util.Arrays;
import java.util.List;


public class test {

    public static void main(String[] args) {
        //Q1
        int[] arraySortColors = {2,0,2,1,1,0};
        SortColors sc = new SortColors(arraySortColors);
        sc.sortColors();
        System.out.println(Arrays.toString(arraySortColors));

        //Q2
        int[] arrayMajorityElement = {2,1,1,3,1,4,5,6};
        MajorityElementII me = new MajorityElementII(arrayMajorityElement);
        List res2 = me.majorityElement();
        for(Object o: res2){
            System.out.println(o);
        }

        //Q3
        int[] arrayHIndex= {3,0,6,1,5};
        HIndex hIndex = new HIndex();
        int res3 = hIndex.hIndex(arrayHIndex);
        System.out.println(res3);



        //Q4
        int[] array1 = {1,2,2,1};
        int[] array2 = {2,2};
        IntersectionOfTwoArrays iota = new IntersectionOfTwoArrays();
        int[] res4 = iota.intersection(array1,array2);
        System.out.println(Arrays.toString(res4));


        //Q5
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = 3;
        FindKClosestElements fkce = new FindKClosestElements();
        List<Integer> res5 = fkce.findClosestElements(arr,k,x);
        for(int n : res5){
            System.out.print(n);
        }
        System.out.println();

        //Q6
        String s = "aab";
        ReorganizeString rs = new ReorganizeString();
        String res = rs.reorganizeString(s);
        System.out.println(res);

        //Q7
        String order = "kqep";
        String s7 = "pekeq";
        CustomSortString css = new CustomSortString();
        String res7 = css.customSortString(order,s7);
        System.out.println(res7);

        //Q8
        int[] arrPancake = {3,2,4,1};
        PancakeSorting ps = new PancakeSorting();
        List<Integer> res8 = ps.pancakeSort(arrPancake);
        for(Integer n : res8){
            System.out.print(n);
        }
        System.out.println();


        //Q9
        int[] array = {1,1,2,2,2,3};
        SortArrayByIncreasingFrequency sabif = new SortArrayByIncreasingFrequency();
        int[] res9 = sabif.frequencySort(array);
        System.out.println(Arrays.toString(res9));

        //Q10
        String[] words ={"the","day","is","sunny","the","the","the","sunny","is","is"};
        int j = 4;
        TopKFrequentWords tkfw = new TopKFrequentWords();
        List<String> res10 = tkfw.topKFrequent(words, j);
        for(String n : res10){
            System.out.print(" " + n +" ");
        }
        System.out.println();







    }





}
