class Solution:
    """
    Time Complexity: O(n) where n is the number of digits in the input number
    Space Complexity: O(n) for creating the list of characters
    """

    def maximum69Number(self, num: int) -> int:
        num_arr = list(str(num))  # Convert number to list of characters
        for i in range(len(num_arr)):
            if num_arr[i] == "6":
                num_arr[i] = "9"
                break  # Only change the first occurrence
        return int("".join(num_arr))  # Convert back to integer
