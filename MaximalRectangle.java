// Form an array with each row, calculate the largest rectangle by using largestRectangleArea function, update the max
// could not pass the larger test all the time
import java.util.Stack;
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int len = matrix.length;
		if(len==0) return 0;		
		int len0 = matrix[0].length;

		int maxarea = 0;
		int[] arr = new int[len0];
		
		for(int i=0; i<len; i++){
			for(int j=0; j<len0; j++){
				if(matrix[i][j]=='0')
					arr[j]=0;
				else
					arr[j]+=1;
			}
			
			maxarea = Math.max(maxarea, largestRectangleArea(arr));
		}
		
		return maxarea;
        
    }


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

