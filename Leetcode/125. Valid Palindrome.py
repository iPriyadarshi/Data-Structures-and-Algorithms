class Solution:
    def isPalindrome(self, s: str) -> bool:
        # Preprocess the string: remove non-alphanumeric and convert to lowercase
        filtered = ''.join(char.lower() for char in s if char.isalnum())

        # Define a recursive helper function
        def check(left: int, right: int) -> bool:
            if left >= right:
                return True
            if filtered[left] != filtered[right]:
                return False
            return check(left + 1, right - 1)

        return check(0, len(filtered) - 1)