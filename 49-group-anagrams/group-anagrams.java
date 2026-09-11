class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            int[] freq = new int[26];

            for (char c : str.toCharArray()) {
                freq[c - 'a']++;
            }

            StringBuilder frequencyString = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                frequencyString.append(freq[i]).append('#');
            }

            String key = frequencyString.toString();

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}