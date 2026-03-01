// Last updated: 3/2/2026, 12:58:22 AM
1class Solution {
2    public int minPartitions(String n) {
3        for (char ch = '9'; ch >= '0'; ch--) {
4            if (n.indexOf(ch) != -1) {
5                return ch - '0';
6            }
7        }
8
9        return -1;
10    }
11}