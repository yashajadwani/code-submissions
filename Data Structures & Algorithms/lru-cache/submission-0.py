class LRUCache:
    class Node:
        def __init__(self, key: int, value: int):
            self.key=key
            self.value=value
            self.prev=None
            self.next=None

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.map = {}
        self.head = self.Node(-1,-1)
        self.tail = self.Node(-1,-1)
        self.head.next = self.tail
        self.tail.prev = self.head
    
    def addNode(self, node: Node):
        tempNode = self.head.next
        tempNode.prev = node
        self.head.next = node
        node.next = tempNode
        node.prev = self.head
       
    
    def deleteNode(self, node: Node):
        prevv = node.prev
        nextt = node.next
        prevv.next = nextt
        nextt.prev = prevv

    def get(self, key: int) -> int:
        if key in self.map:
            resNode = self.map[key]
            self.deleteNode(resNode)
            self.addNode(resNode)
            return resNode.value
        return -1

    def put(self, key: int, value: int) -> None:
        if key in self.map:
            resNode = self.map[key]
            self.deleteNode(resNode)
            resNode.value=value
            self.addNode(resNode)
            return
        if self.capacity == len(self.map):
            resNode = self.tail.prev
            del self.map[resNode.key]
            self.deleteNode(resNode)
            newNode = self.Node(key,value)
            self.map[key] = newNode
            self.addNode(newNode)
        else:
            newNode = self.Node(key,value)
            self.map[key] = newNode
            self.addNode(newNode)
        
    