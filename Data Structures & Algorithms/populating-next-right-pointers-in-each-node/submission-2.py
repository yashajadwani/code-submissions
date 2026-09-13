"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return root
        q = deque()
        q.append(root)
        while q:
            q_len = len(q)
            for i in range(q_len):
                n = q.popleft()
                if i < q_len-1:
                  n.next = q[0]
                else:
                    n.next=None
                if n.left:
                    q.append(n.left)
                if n.right:
                    q.append(n.right)
        return root
              
        