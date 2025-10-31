# Last updated: 10/31/2025, 10:48:05 PM
class Solution:
    def smallestNumber(self, n: int) -> int:
        l=list(bin(n)[2:])
        
        for i in range(len(l)):
            if l[i]=='0':
                l[i]='1'
        return int(''.join(l),2)