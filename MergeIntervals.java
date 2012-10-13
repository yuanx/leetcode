import java.util.Comparator;
import java.util.Collections;
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
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = intervals.size();
        ArrayList<Interval> re = new ArrayList<Interval>();
        if(len==0) return re;
        Collections.sort(intervals, Int_compare);
        Interval travel = intervals.get(0);
        if(len==1){
            re.add(travel);
            return re;
        }

        for(int i=1; i<len; i++){
            Interval temp = intervals.get(i);
            if(temp.end<travel.start || temp.start > travel.end){
                re.add(travel);
                travel = temp;
            }
            else{
                travel.start = Math.min(travel.start, temp.start);
                travel.end = Math.max(travel.end, temp.end);

            }
        }
        
        re.add(travel);
        return re;
        
        
    }
    
	static final Comparator<Interval> Int_compare = new Comparator<Interval>(){
		public int compare(Interval i, Interval j){
			return new Integer(i.start).compareTo(new Integer(j.start));
		}
	};	
}

