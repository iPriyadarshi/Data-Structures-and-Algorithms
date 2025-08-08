# https://www.geeksforgeeks.org/problems/reverse-a-stack/1

class Solution:
    def reverse(self, St):
        # code here
        if St:
            x = St.pop()
            self.reverse(St)
            self.insertAtBottom(St, x)

    def insertAtBottom(self, stack, x):
        if not stack:
            stack.append(x)
        else:
            a = stack.pop()
            self.insertAtBottom(stack, x)
            stack.append(a)
