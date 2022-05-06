import java.util.*;

public class Question3 {
    public List<List<String>> groupAnagrams(String[] strs){
        if(strs == null || strs.length == 0){
            return null;
        }

        Map<String, List<String>> map = new HashMap();
        for(String s: strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars, 0, chars.length);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
