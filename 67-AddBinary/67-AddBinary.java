// Last updated: 2/15/2026, 11:48:56 PM
1class Solution 
2{
3  public String addBinary(String a, String b) 
4  {
5    StringBuilder sb = new StringBuilder();
6    int carry = 0;
7    int i = a.length() - 1;
8    int j = b.length() - 1;
9
10    while (i >= 0 || j >= 0 || carry == 1) 
11    {
12      if(i >= 0)
13        carry += a.charAt(i--) - '0';
14      if(j >= 0)
15        carry += b.charAt(j--) - '0';
16      sb.append(carry % 2);
17      carry /= 2;
18    }
19    return sb.reverse().toString();
20  }
21}