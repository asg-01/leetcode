class Solution(object):
    def smallestRepunitDivByK(self, k):
        # if k % 2 == 0 or k % 5 == 0: return -1  # this trick may save a little time
        hit, n, ans = [False] * k, 0, 0
        while True:  # at most k times, because 0 <= remainder < k
            ans, n = ans + 1, (n * 10 + 1) % k  # we only focus on whether to divide, so we only need to keep the remainder.
            if n == 0: return ans  # can be divisible
            if hit[n]: return -1  # the remainder of the division repeats, so it starts to loop that means it cannot be divisible.
            hit[n] = True