# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

from typing import Optional

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        # Dummy node to simplify result list creation
        dummy = ListNode()
        current = dummy  # Pointer to build the resulting linked list
        carry = 0  # Variable to store carry from addition

        # Loop through both lists until we process all digits
        while l1 or l2 or carry:
            # Extract values from the current nodes, if they exist
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0

            # Compute sum and carry
            total = val1 + val2 + carry
            carry, digit = divmod(total, 10)  # Extract new digit and update carry

            # Create a new node for the computed digit
            current.next = ListNode(digit)
            current = current.next  # Move to the next node

            # Move to the next nodes in the input lists (if they exist)
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next

        # Return the sum as a linked list (skipping the dummy node)
        return dummy.next
