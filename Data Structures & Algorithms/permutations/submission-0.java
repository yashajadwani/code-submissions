class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        dfs(result, visited, path, nums);
        return result;
    }

    void dfs(List<List<Integer>> result, Set<Integer> visited, List<Integer> path, int[] nums) {

        if(path.size()==nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=0; i<nums.length;i++){
            if(!visited.contains(nums[i])) {
                path.add(nums[i]);
                visited.add(nums[i]);
                dfs(result, visited, path, nums);
                path.remove(path.size()-1);
                visited.remove(nums[i]);
            }
        }
    }
}
