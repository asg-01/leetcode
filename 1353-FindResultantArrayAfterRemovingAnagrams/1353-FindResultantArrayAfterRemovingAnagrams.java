// Last updated: 10/29/2025, 3:08:13 AM
class Solution {
    public List<String> removeAnagrams(String[] words) {
        String prev ="";
        List<String> re=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            char[] ch=words[i].toCharArray();
            Arrays.sort(ch);
            String curr=String.valueOf(ch);
            if(!curr.equals(prev)){
                re.add(words[i]);
                prev=curr;
            }
        }
        return re;
    }
}