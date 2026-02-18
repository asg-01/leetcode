// Last updated: 2/18/2026, 11:33:14 PM
1class Solution {
2    public boolean hasAlternatingBits(int n) {
3        String binary = Integer.toBinaryString(n);
4        for(int i = 0; i< binary.length()-1; i++){
5            if(binary.charAt(i) == binary.charAt(i+1)){
6                return false;
7            }
8        }
9        return true;
10    }
11}