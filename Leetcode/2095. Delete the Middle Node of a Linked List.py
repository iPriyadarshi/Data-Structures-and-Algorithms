from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # list has only one ele
        if not head or not head.next:
            return None

        # finding length
        def find_length(head):
            count = 0
            curr = head
            while curr:
                count += 1
                curr = curr.next
            return count

        n = find_length(head)
        # iterating to middle ele
        curr = head
        prev = None
        for i in range(n // 2):
            prev = curr
            curr = curr.next
        # deleting middle ele
        prev.next = curr.next
        return head
