import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");

        if (pattern.length() != arr.length) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = arr[i];

            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(word)) {
                    return false;
                }
            } else {
                if (map.containsValue(word)) {
                    return false;
                }

                map.put(ch, word);
            }
        }

        return true;
    }
}