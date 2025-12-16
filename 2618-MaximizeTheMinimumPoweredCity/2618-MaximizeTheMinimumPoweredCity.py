# Last updated: 12/17/2025, 12:07:56 AM
class Solution:
    def maxPower(self, stations: List[int], r: int, k: int) -> int:
        n = len(stations)
        power = [0] * (n+1)
        for i in range(n):
            power[max(i-r, 0)] += stations[i]
            power[min(i+r+1, n)] -= stations[i]
        def check(val: int) -> bool:
            power_copy = power.copy()
            curr_power = 0
            remaining = k
            for i in range(n):
                curr_power += power_copy[i]
                if curr_power < val:
                    # check how many stations you need to add
                    stations_to_add = val - curr_power
                    if stations_to_add > remaining: return False
                    # add these stations
                    curr_power += stations_to_add
                    power_copy[min(n, i + 1 + 2*r)] -= stations_to_add
                    remaining -= stations_to_add
            return True
        # this is a maximization problem
        res = 0
        lo, hi = min(stations), sum(stations)+k
        while lo <= hi:
            mid = (lo + hi)//2
            if check(mid):
                res = mid
                lo = mid + 1
            else:
                hi = mid - 1
        return res
        