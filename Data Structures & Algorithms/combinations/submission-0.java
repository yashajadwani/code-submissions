class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for(int i=1;i<=n;i++)
            nums.add(i);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, k, result, path, 0);
        return result;
    }

   void dfs(List<Integer> nums, int k, List<List<Integer>> result, List<Integer> path, int idx) {
        if(path.size()==k) {
            result.add(new ArrayList<>(path));
            return;
        }
        if(idx==nums.size()) {
            return;
        }
        path.add(nums.get(idx));
        dfs(nums, k, result, path, idx+1);
        path.remove(path.size()-1);
        dfs(nums, k, result, path, idx+1);
    }
}