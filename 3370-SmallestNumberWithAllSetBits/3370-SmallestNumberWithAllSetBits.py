# Last updated: 10/29/2025, 11:17:31 AM
class Solution:
    def smallestNumber(self, n: int) -> int:
        l=list(bin(n)[2:])
        
        for i in range(len(l)):
            if l[i]=='0':
                l[i]='1'
        return int(''.join(l),2)