# Using stack to remove substrings
# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution(object):
    def removeSubStr(self, string, matchStr):
        stack = []
        for ch in string:
            if stack and (ch == matchStr[1]) and (stack[-1] == matchStr[0]):
                stack.pop()
            else:
                stack.append(ch)
        return "".join(stack)

    def maximumGain(self, s, x, y):
        """
        :type s: str
        :type x: int
        :type y: int
        :rtype: int
        """
        n = len(s)
        score = 0
        if x > y:
            maxStr = "ab"
            minStr = "ba"
        else:
            maxStr = "ba"
            minStr = "ab"

        # First pass
        temp_first = self.removeSubStr(s, maxStr)
        l = len(temp_first)
        char_removed = n - l
        pair_removed = char_removed // 2
        score += pair_removed * max(x, y)

        # Second pass
        temp_second = self.removeSubStr(temp_first, minStr)
        char_removed = l - len(temp_second)
        pair_removed = char_removed // 2
        score += pair_removed * min(x, y)

        return score


# Without using stack
# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution(object):
    def removeSubStr(self, string, matchStr):
        s = list(string)
        write = 0
        for read in range(len(s)):
            s[write] = s[read]
            write += 1
            if (
                write >= 2
                and s[write - 2] == matchStr[0]
                and s[write - 1] == matchStr[1]
            ):
                write -= 2  # remove the pair
        return "".join(s[:write])

    def maximumGain(self, s, x, y):
        """
        :type s: str
        :type x: int
        :type y: int
        :rtype: int
        """
        n = len(s)
        score = 0
        if x > y:
            maxStr = "ab"
            minStr = "ba"
        else:
            maxStr = "ba"
            minStr = "ab"

        # First pass
        temp_first = self.removeSubStr(s, maxStr)
        l = len(temp_first)
        char_removed = n - l
        pair_removed = char_removed // 2
        score += pair_removed * max(x, y)

        # Second pass
        temp_second = self.removeSubStr(temp_first, minStr)
        char_removed = l - len(temp_second)
        pair_removed = char_removed // 2
        score += pair_removed * min(x, y)

        return score
