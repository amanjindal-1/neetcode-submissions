class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";
        HashMap<Character, Integer> hm = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray()) hm.put(c, hm.getOrDefault(c, 0) + 1);

        int have = 0, need = hm.size();
        int[] res = {-1, -1};

        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if(hm.containsKey(c) && window.get(c).equals(hm.get(c))){
                have++;
            }

            while (have == need) {
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (hm.containsKey(leftChar) && window.get(leftChar) < hm.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
