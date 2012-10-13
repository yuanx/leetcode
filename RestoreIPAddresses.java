public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> re = new ArrayList<String>();
    	String[] sb = new String[4];
		
		getIpAddresses(re, sb, s, 0);
		
		return re;
    }

	public void getIpAddresses(ArrayList<String> re, String[] sb, String s, int level){
		int len = s.length();
		
		if(level<4 && (len<4-level || len>3*(4-level)))
			return;
        
        if(level == 4 && len>0)
            return;	
            
		if(level ==4){
			StringBuilder temp = new StringBuilder();
			for(int i=0; i<4; i++){
				temp.append(sb[i]);
				temp.append('.');
			}
			temp.deleteCharAt(temp.length()-1);
			re.add(temp.toString());
			return;
		}
		
		if(s.charAt(0) == '0'){
			sb[level] = "0";
			getIpAddresses(re, sb, s.substring(1), level+1);
		}
		else{
			for(int j=1; j<4; j++){
				if(j<=len){
					String stemp = s.substring(0,j);
					int itemp = Integer.parseInt(stemp);
					if(itemp<=255){
						sb[level] = stemp;
						getIpAddresses(re, sb, s.substring(j), level+1);
					}
				}
			}			
		}
		
	}
	
}