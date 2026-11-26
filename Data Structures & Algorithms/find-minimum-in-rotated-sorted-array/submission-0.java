class Solution {
    public int findMin(int[] nums) {
        // since array is sorted and rotated this means
        // that array has 2 section left sorted array and right sorted array
        // if mid > left then we are in left section which is greater so we move to right secion
        // and if its smaller then ans is on left side
        int ans = nums[0];
        int l = 0, r = nums.length - 1;
        while(l <= r){
            if(nums[l] < nums[r]){
                ans = Math.min(ans, nums[l]);
                break;
            }

            int m = (l + r) / 2;
            ans = Math.min(ans, nums[m]);

            if(nums[l] <= nums[m]){
                l = m + 1;
            } else r = m - 1;
        }
        return ans;
    }
}
