class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left = 1
        right = max(piles)
        result = right
        while left <= right:
            k=(left+right)//2
            count=0
            for bananas in piles:
                count+= math.ceil(bananas/k)
            if count<=h:
                result=k
                right=k-1
            else:
                left=k+1
        return result

        