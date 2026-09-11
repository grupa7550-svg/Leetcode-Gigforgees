import java.util.HashMap;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        HashMap<Character, Integer> counts = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            int currentCount = counts.getOrDefault(c, 0);
            if (currentCount == 0) {
                return false;
            }
            counts.put(c, currentCount - 1);
        }

        return true;
    }
}