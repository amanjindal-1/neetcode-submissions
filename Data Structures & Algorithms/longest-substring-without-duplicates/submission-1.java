class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len == 0) return len;
        int ans = 0, i = 0, j = i + 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(i));
        while(j < len){
            ans = Math.max(ans, j - i);
            char ch = s.charAt(j);
            while(set.contains(ch) && i < j){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(ch);
            j++;
        }
        ans = Math.max(ans, j - i);
        return ans;
    }
}
