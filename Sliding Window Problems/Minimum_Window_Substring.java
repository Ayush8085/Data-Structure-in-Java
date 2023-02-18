import java.util.HashMap;
import java.util.Map;

public class Minimum_Window_Substring {

    // Return the minimum size of the window in which all the characters of s2 are present in s1 atleast in that many quantity.
    
    private static final String Map = null;

    public static void main(String[] args) {
        
        Map<Character, Integer> map = new HashMap<>();
        String s1 = "ADOBECODEBANC";
        String s2 = "ABC";

        // String s1 = "TOTMTAPTAT";
        // String s2 = "TTA";

        for(int i=0; i<s2.length(); i++) {
            if(map.containsKey(s2.charAt(i))) {
                int count = map.get(s2.charAt(i)) + 1;
                map.put(s2.charAt(i), count);
            }
            else {
                map.put(s2.charAt(i), 1);
            }
        }

        int keyCount = map.size();

        int start = 0;
        int end = 0;
        
        int min = Integer.MAX_VALUE;
        while(end < s1.length()) {

            if(map.containsKey(s1.charAt(end))) {
                int count = map.get(s1.charAt(end)) - 1;
                if(count == 0) {
                    keyCount--;
                }
                map.put(s1.charAt(end), count);
            }
            else {
                map.put(s1.charAt(end), 1);
                keyCount++;
            }

            if(keyCount < (end-start+1)) {
                end++;
            }
            else if(keyCount > (end-start+1)) {
                while(keyCount > (end-start+1)) {
                    int count = map.get(s1.charAt(start)) - 1;
                    if(count == 0) {
                        keyCount--;
                    }
                    else {
                        map.put(s1.charAt(start), count);
                    }
                    start++;
                }
                if(keyCount == 0) {
                    min = Math.min((end-start+1), min);
                }
                end++;
            }
            else {
                min = Math.min((end-start+1), min);

                end++;
            }
        }
    }
}
