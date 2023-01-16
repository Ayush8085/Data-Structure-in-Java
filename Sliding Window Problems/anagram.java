import java.util.HashMap;

public class anagram {
    public static void main(String args[]) {

        String s = "aabaabaaa";
        String ptr = "aba";

        int k = ptr.length();

        HashMap<Character, Integer> map = new HashMap<>();
        int keyCount = 0;

        for(int i=0; i<k; i++) {
            if(map.containsKey(ptr.charAt(i))) {
                int count = map.get(ptr.charAt(i));
                map.put(ptr.charAt(i), ++count);
            }
            else {
                map.put(ptr.charAt(i), 1);
                keyCount++;
            }
        }
        System.out.println("This is the map: " +map);
        System.out.println("This is the keyCount: "+keyCount);
        System.out.println();

        int start = 0;
        int end = 0;
        int ans = 0;

        while(end < s.length()) {

            if(map.containsKey(s.charAt(end))) {
                int count = map.get(s.charAt(end));
                map.put(s.charAt(end), --count);
                if(map.get(s.charAt(end))==0) {
                    keyCount--;
                }
            }

            if((end-start+1) < k) {
                end++;
            }
            else if((end-start+1) == k) {
                if(keyCount==0) {
                    ans++;
                }
                if(map.containsKey(s.charAt(start))) {
                    int count = map.get(s.charAt(start));
                    map.put(s.charAt(start), ++count);
                    if(map.get(s.charAt(start))==1) {
                        keyCount++;
                    }
                }

                start++;
                end++;
            }
        }

        System.out.print("\nTotal no. of anagrams present in the given string: " +ans);

    }
}
