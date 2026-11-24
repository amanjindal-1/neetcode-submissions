class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int sum = -nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            while (j < k) {
                if (nums[j] + nums[k] < sum)
                    j++;
                else if (nums[j] + nums[k] > sum)
                    k--;
                else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
        }
        return ans;
    }
}
