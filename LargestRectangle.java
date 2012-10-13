/* 
   Use two stacks, one for height, one for index. if the current height is larger than the peek of height stack, push it in
   update the index stack as well, if it is equal, skip. if it is smaller, pop the stack, calculate the current max, push the
   correct height and index in (current height and last pop out index)
   Don't forget the calculate the height after the loop
*/

import java.util.Stack;
public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height.length == 0) return 0;
		if(height.length == 1) return height[0];
		
		Stack<Integer> hs = new Stack<Integer>();
		Stack<Integer> inds = new Stack<Integer>();
		hs.push(height[0]);
		inds.push(0);
		
		int localmax = 0;
		int max = 0;
		int lastindex = 0;
		int lasth = 0;
		for(int i=1; i<height.length; i++){
			if(height[i]>hs.peek()){
				hs.push(height[i]);
				inds.push(i);
			}
			else if(height[i]<hs.peek()){
				while(!hs.isEmpty() && hs.peek()>height[i]){
					lasth = hs.pop();
					lastindex = inds.pop();
					localmax = (i-lastindex)*lasth;
					max = max > localmax ? max : localmax;
				}				
				hs.push(height[i]);
				inds.push(lastindex);
			}
		}		
		while(!hs.isEmpty()){
			lastindex = inds.pop();
			lasth = hs.pop();
			localmax = (height.length-lastindex)*lasth;
			max = max > localmax ? max :localmax;			
		}
		
		return max;

    }
}