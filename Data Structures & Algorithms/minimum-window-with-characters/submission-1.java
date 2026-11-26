class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch : t.toCharArray()) hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        String ans = "";
        int l = -1, r = 0, n = s.length();
        while(r < n){
            char ch = s.charAt(r);
            if(hm.containsKey(ch)){
                if(l == -1){
                    l = r;
                }

                hm.put(ch, hm.get(ch) - 1);

                if(hm.get(ch) < 0 && s.charAt(l) == ch){
                    hm.put(ch, hm.get(ch) + 1);
                    l++;
                    while(l < r && (!hm.containsKey(s.charAt(l)) || hm.get(s.charAt(l)) < 0)){
                        char c = s.charAt(l);
                        if(hm.containsKey(c)){
                            hm.put(c, hm.get(c) + 1);
                        }
                        l++;
                    }
                }

                boolean flag = true;
                for(Character k : hm.keySet()){
                    if(hm.get(k) > 0){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    String potential = s.substring(l, r + 1);
                    System.out.println(potential + " " + l + " " + r);
                    System.out.println(potential);
                    if(t.length() == potential.length()) return potential;
                    if(ans.length() == 0) ans = potential;
                    else if(ans.length() > potential.length()) ans = potential;
                }
            }
            r++;
        }
        return ans;
    }
}
