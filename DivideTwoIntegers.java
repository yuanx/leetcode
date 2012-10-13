public class Solution {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int flag = 1;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        
        if(dividend>min && divisor>min){
            if(dividend<0){
                dividend = 0-dividend;
                flag = 0-flag;
            }
            
            if(divisor<0){
                divisor = 0-divisor;
                flag = 0-flag;
            }
            
            if(dividend<divisor) return 0;
            if(dividend==divisor) return flag;
            
            int origdivisor = divisor;
            int lastcount=1;
            int lastdivisor = divisor;
            int count = 1;
            
            while(dividend>divisor && divisor>0){
                lastcount = count;
                lastdivisor = divisor;
                divisor = divisor+divisor;
                count = count + count;                
            }
            
            int remainder = dividend - lastdivisor;
            if(remainder>=origdivisor)
                return flag==1 ? (lastcount+divide(remainder,origdivisor)) : (0-(lastcount+divide(remainder,origdivisor)));
            else
                return flag==1 ? lastcount : 0-lastcount;
        }
        else if(divisor == min){
            if(dividend == divisor)
                return 1;
            else
                return 0;                            
        }        
        else{
            if(divisor<0)
                return 1+divide(dividend-divisor, divisor);
            else
                return -1+divide(dividend+divisor, divisor);
        }
        
        
    }
}