"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def canAttendMeetings(self, intervals: List[Interval]) -> bool:
        intervals.sort(key=lambda x:x.start)
        start=-1
        end=-1
        for interval in intervals:
            if start==-1 and end==-1:
                start=interval.start
                end=interval.end
            elif (interval.start<=start and interval.end<=start) or (interval.start>=end and interval.end>=end):
                start=interval.start
                end=interval.end
                continue
            else:
                return False
        return True