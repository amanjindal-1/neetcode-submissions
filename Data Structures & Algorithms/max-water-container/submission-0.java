class Solution {
    public int maxArea(int[] nums) {
        int i = 0, j = nums.length - 1, ans = 0;
        while(i < j){
            int h = Math.min(nums[i], nums[j]);
            ans = Math.max(ans, h * (j - i));
            if(nums[i] > nums[j]) j--;
            else i++;
        }
        return ans;
    }
}
