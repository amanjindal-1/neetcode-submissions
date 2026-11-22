class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            ans[i] = 1;
        }
        int carry = 1;
        for(int i = 0; i < nums.length; i++){
            ans[i] *= carry;
            carry *= nums[i];
        }
        carry = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            ans[i] *= carry;
            carry *= nums[i];
        }
        return ans;
    }
}  
