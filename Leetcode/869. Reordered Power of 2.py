class Solution:
    def getSortedStr(self, n: int) -> str:
        s = str(n)
        # Sort the characters (digits) and join them back into a string
        return "".join(sorted(s))

    def reorderedPowerOf2(self, n: int) -> bool:
        # Get the sorted digit string of the input number
        s = self.getSortedStr(n)

        # Check against all powers of 2 from 2^0 to 2^29
        # (2^30 is over 10 digits, so we stop at 2^29)
        for p in range(30):
            # Compute 2^p and get its sorted digit string
            power_str = self.getSortedStr(1 << p)
            # If the sorted digits match, it's a valid rearrangement
            if s == power_str:
                return True

        # If no match found, return False
        return False
