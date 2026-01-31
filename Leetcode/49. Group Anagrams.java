class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        // HashMap:- Key = sorted strings and Value = list of anagrams
        HashMap<String,List<String>> anagrams = new HashMap<>();
        int n = strs.length;
        for(int i=0;i<n;i++){
            String sortedKey = sorted(strs[i]);
            if(anagrams.containsKey(sortedKey)){
                anagrams.get(sortedKey).add(strs[i]);
            } else {
                anagrams.put(sortedKey, new ArrayList<>(Arrays.asList(strs[i])));
            }
        }

        // storing in result
        for (List<String> group : anagrams.values()) {
            result.add(group);
        }
        return result;
    }

    private String sorted(String str){
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }
}