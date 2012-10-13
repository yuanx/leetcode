/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<Interval> re = new ArrayList<Interval>();
        
        int len = intervals.size();
        int i = 0;
        
        while(i<len){
            Interval temp = intervals.get(i);
            
            if(temp.end < newInterval.start)
                re.add(temp);
            else if(temp.start>newInterval.end){
                break;
            }
            else{
                newInterval.start = Math.min(temp.start,newInterval.start);
                newInterval.end = Math.max(temp.end, newInterval.end);
            }
            i++;
            
        }
        
        re.add(newInterval);
        
        while(i<len){
            re.add(intervals.get(i));
            i++;
        }
        
        return re;
            
        
    }
}