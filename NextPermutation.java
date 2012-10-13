public class Solution {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = num.length;
    	if(len<=1) return;
		int i= len-1;
		while(i>0){
			if(num[i]<=num[i-1])
				i--;
			else
				break;
		}
		if(i==0){
			reverse(num);
			return;
		}
		
		int p = i-1;
		while(i<len){
			if(num[i]>num[p])
				i++;
			else
				break;
		}
        i--;
		swap(num, p, i);
		p++;
		int q = len-1;
		while(q>p){
			swap(num,p,q);
			p++;
			q--;
		}
		

    }
    
    public void swap(int[] num, int i, int j){
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;       
    }

	public void reverse(int[] num){
		if(num.length==1) return;
		int p = 0;
		int q = num.length-1;
		while(q>p){
			swap(num,p,q);
			p++;
			q--;
		}
	}
}