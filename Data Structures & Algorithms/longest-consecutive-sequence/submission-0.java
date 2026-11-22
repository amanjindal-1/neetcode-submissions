class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int ans = 0;
        for(int num : nums){
            if(!set.contains(num - 1)){
                int count = 1;
                int cur = num + 1;
                while(set.contains(cur)){
                    count++;
                    cur++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
