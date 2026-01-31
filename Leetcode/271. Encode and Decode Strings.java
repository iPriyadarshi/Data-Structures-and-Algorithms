class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedStr = new StringBuilder();
        for(String s : strs){
            encodedStr.append(s.length());
            encodedStr.append("#");
            encodedStr.append(s);
        }
        return encodedStr.toString();

    }

    public List<String> decode(String str) {
        List<String> decodedStrs = new ArrayList<String>();
        int i = 0;
        int n = str.length();
        while(i<n){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            String s = str.substring(j+1,j+1+length);
            decodedStrs.add(s);
            i = j+1+length;
        }
        return decodedStrs;
    }
}
