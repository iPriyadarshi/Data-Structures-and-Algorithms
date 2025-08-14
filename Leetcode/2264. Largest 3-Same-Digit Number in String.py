class Solution:
    def largestGoodInteger(self, num: str) -> str:
        # Time Complexity: O(n) where n is length of input string num
        # - We check each good_int against the entire string using 'in' operator
        # Space Complexity: O(1)
        # - We use a fixed size list of 10 possible good integers
        good_int = [
            "999",
            "888",
            "777",
            "666",
            "555",
            "444",
            "333",
            "222",
            "111",
            "000",
        ]
        for i in good_int:
            if i in num:
                return i
        return ""
