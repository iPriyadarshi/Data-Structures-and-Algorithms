# https://www.geeksforgeeks.org/problems/linked-list-insertion-1587115620/0

class Node:
    def __init__(self,data):
        self.data=data
        self.next=None


class Solution:
    """
    Time Complexity: O(n) where n is the length of the linked list
    Space Complexity: O(1) as only constant extra space is used
    """

    def insertAtEnd(self, head, x):
        new_node = Node(x)

        # If the list is empty, the new node becomes the head
        if head is None:
            return new_node

        # Traverse to the end of the list
        current = head
        while current.next:
            current = current.next

        # Link the new node at the end
        current.next = new_node
        return head
