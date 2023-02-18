import java.util.HashMap;
import java.util.Map;

public class Count_Occurance_Anagram {

    // Return the maximum no. of anagrams of 'b' is possible in 'a'.
    
    public static void main(String[] args) {
        
        Map<Character, Integer> map = new HashMap<>();
        // String a = "forxxorfxdofr";
        // String b = "for";
        
        String a = "aabaabaa";
        String b = "aaba";

        int k = b.length();

        int mapCount = 0;
        for(int i=0; i<k; i++) {
            if(map.containsKey(b.charAt(i))) {
                int count = map.get(b.charAt(i)) + 1;
                map.put(b.charAt(i), count);
            }
            else {
                map.put(b.charAt(i), 1);
                mapCount++;
            }
        }

        // System.out.println(map+ " " +mapCount);

        int start = 0;
        int end = 0;

        int ans = 0;

        while(end < a.length()) {

            if(map.containsKey(a.charAt(end))) {
                int count = map.get(a.charAt(end)) - 1;
                map.put(a.charAt(end), count);
                if(count == 0) {
                    mapCount--;
                } 
            }
            // else {
            //     map.put(b.charAt(end), 1);
            //     mapCount++;
            // }

            if((end-start+1) < k) {
                end++;
            }
            else {
                if(mapCount==0) {
                    ans++;
                }

                if(map.containsKey(a.charAt(start))) {
                    int count = map.get(a.charAt(start)) + 1;
                    map.put(a.charAt(start), count);
                    if(count > 0) {
                        mapCount++;
                    }
                }

                start++;
                end++;
            }
        }

        System.out.println(ans);

    }
}
