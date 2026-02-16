// Last updated: 2/17/2026, 12:01:40 AM
1public class Solution {
2    
3    public int reverseBits(int num) {
4        
5        num = ((num & 0xffff0000) >>> 16) | ((num & 0x0000ffff) << 16);
6        num = ((num & 0xff00ff00) >>> 8) | ((num & 0x00ff00ff) << 8);
7        num = ((num & 0xf0f0f0f0) >>> 4) | ((num & 0x0f0f0f0f) << 4);
8        num = ((num & 0xcccccccc) >>> 2) | ((num & 0x33333333) << 2);
9        num = ((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1);
10        
11        return num;
12        
13    }
14}