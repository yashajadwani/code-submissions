class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for char in s:
            if char=='{' or char=='[' or char =='(':
                stack.append(char)
            else:
                match char:
                    case '}':
                                if not stack or stack[-1]!='{':
                                    return False
                                stack.pop()
                    case ']': 
                                if not stack or stack[-1]!='[':
                                    return False
                                stack.pop()
                              
                    case ')': 
                                if not stack or stack[-1]!='(':
                                    return False
                                stack.pop()
                    case _: return False
        
        if stack :
             return False
        return True
            

        