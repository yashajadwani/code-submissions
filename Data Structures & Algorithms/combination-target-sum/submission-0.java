class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> path = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, nums, target, 0, path);
        return result;
    }

    public void dfs(List<List<Integer>> result, int[] nums, int target, int idx, List<Integer> path){
        if(target==0) {
            result.add(new ArrayList(path));
            return;
        }

        if (target < 0 || idx >= nums.length) {
            return;
        }

        path.add(nums[idx]);
        dfs(result, nums,target-nums[idx], idx, path);
        path.remove(path.size()-1);
        dfs(result, nums, target, idx+1, path);
    }
}
