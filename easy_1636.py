# 1636. Sort Array by Increasing Frequency
class Solution:
    def frequencySort(self, nums: List[int]) -> List[int]:
        count = Counter(nums) # Counter method: creates a hash map for nums list

        def custom_sort(n):
            return (count[n], -n)

        nums.sort(key=custom_sort) # sort nums ascending

        return nums
