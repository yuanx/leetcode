public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l1 = num1.length();
        int l2 = num2.length();
    	int diff;
		int len;
		int carry = 0;
		String re = "";
		
		if(num1.charAt(0)=='0' || num2.charAt(0)=='0')
			return "0";
		
		// Make them with the same length
		if(l1>l2){
			diff = l1-l2;
			while(diff-->0)
				num2 = '0' + num2;
			len = l1;
		}
		else{
			diff = l2-l1;
			while(diff-->0)
				num1 = '0' + num1;
			len = l2;
		}
		
		int p = len-1;
		int q = len-1;
		
		while(q>=0){
			int s1 = p;
			int s2 = q;
			int sum = 0;
			
			while(s1<s2){
				sum += getnum(num1,s1)*getnum(num2,s2);
				sum += getnum(num2,s1)*getnum(num1,s2);
				s1++;
				s2--;
			}
			if(s1==s2)
				sum += getnum(num1,s1)*getnum(num2,s2);
			sum += carry;
			re = Integer.toString(sum%10)+re;
			carry = sum/10;
			
			if(p>0)
				p--;
			else
				q--;
		}
		
		if(carry>0)
			re = Integer.toString(carry) + re;
        int n = 0;
		while(re.charAt(n)=='0')
			n++;
        return re.substring(n);
    }
    
    public int getnum(String S, int i){
    	return S.charAt(i)-'0';
    }
}