# https://www.geeksforgeeks.org/problems/count-nodes-of-linked-list/0

"""
#Linked list class
class LinkedList:
    def __init__(self):
        self.head=None
        self.tail=None
"""


class Solution:
    # Function to count nodes of a linked list.
    # Time Complexity: O(n) where n is number of nodes
    # Space Complexity: O(1) since we only use a single variable length
    def getCount(self, head):
        # code here
        length = 0
        currNode = head
        while currNode:
            length += 1
            currNode = currNode.next
        return length
