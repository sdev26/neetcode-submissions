class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>ans=new ArrayList<>();
        HashMap<String,List<String>>hm=new HashMap<>();
        for(int j=0;j<strs.length;j++){
            String s=strs[j];
              int[] freq = new int[26];

    for (char c : s.toCharArray()) {
        freq[c - 'a']++;
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 26; i++) {
        if (freq[i] != 0) {
            sb.append((char)('a' + i));
            sb.append('#');
            sb.append(freq[i]);
            sb.append('#');
        }
    }

    String key = sb.toString();

    if (!hm.containsKey(key)) {
        hm.put(key, new ArrayList<>());
    }

    hm.get(key).add(s);

        }
        return new ArrayList<>(hm.values());

    }
}
