class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length());
            sb.append(',');
        }
        sb.append(',');
        for(String s : strs){
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int idx = str.indexOf(",,");
        if(idx <= 0) return List.of();
        int[] idxMap = Arrays.stream(str.substring(0, idx).split(","))
        .mapToInt(Integer::parseInt).toArray();
        List<String> ans = new ArrayList<>();
        
        int prevIdx = idx + 2;
        for(int i : idxMap){
            ans.add(str.substring(prevIdx, prevIdx + i));
            prevIdx += i;
        }

        return ans;
    }
}
