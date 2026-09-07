class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits.isEmpty()) return result;
        
        
        HashMap<String, String> map = new HashMap<>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        dfs(digits,0,result,new StringBuilder(),map);
        return result;
    }

    void dfs(String digits, int idx, List<String> result, StringBuilder path, HashMap<String, String> map) {
        if(digits.length()==idx) {
            result.add(path.toString());
            return;
        }
       
            String letters= map.get(String.valueOf(digits.charAt(idx)));
            for(int j=0; j<letters.length();j++) {
                path=path.append(letters.charAt(j));
                dfs(digits,idx+1,result,path,map);
                path=path.deleteCharAt(path.length()-1);
            }
    }
}
