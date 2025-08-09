class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)

        # Sorting the array as index is not required
        nums.sort()
        result = []

        # Fixing one element n1
        for i in range(n):
            if i > 0 and nums[i] == nums[i - 1]:  # Skip duplicate elements
                continue

            n1 = nums[i]
            target = -n1

            # Call the twoSum helper function to find n2 and n3
            self.twoSum(nums, target, i + 1, result)

        return result

    def twoSum(self, nums: List[int], target: int, start: int, result: List[List[int]]):
        end = len(nums) - 1
        while start < end:
            sum_of_two = nums[start] + nums[end]
            if sum_of_two < target:
                start += 1
            elif sum_of_two > target:
                end -= 1
            else:
                # Found a valid triplet
                result.append([-target, nums[start], nums[end]])

                # Skip duplicates for n2 and n3
                while start < end and nums[start] == nums[start + 1]:
                    start += 1
                while start < end and nums[end] == nums[end - 1]:
                    end -= 1

                # Move pointers
                start += 1
                end -= 1
