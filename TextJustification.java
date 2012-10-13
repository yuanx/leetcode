public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        if(L==0){
            res.add("");
            return res;
        }
        int i = 0;
		int count = 0;
		int len = 0;
		int j=0;
		while(i<words.length){
			len += (words[i].length()+1);			
			if(len-1<=L){
				i++;
				count++;
				continue;
			}
			else{
				fillString(words, res, count, i-count, L, 0);
				len = 0;
				count=0;
			}
		}
		
		fillString(words, res, count, i-count, L, 1);
		
		return res;		
    }

	public void fillString(String[] words, ArrayList<String> res, int count, int start, int L, int flag){
		StringBuilder sb = new StringBuilder(L);
		if(count == 1){
			sb.append(words[start]);
            for(int i=0; i<L-words[start].length(); i++)
                sb.append(" ");
            res.add(sb.toString());
			return;
		}
				
		//calculate spaces
		int wordlen = 0;
		for(int i = start; i<start+count; i++){
			wordlen += words[i].length();
		}
		
		// Last line
		if(flag == 1){
			int totalspace = L-wordlen;
			for(int i=0; i<count-1; i++){
				sb.append(words[start+i]);
				sb.append(" ");
				totalspace--;
			}
			sb.append(words[start+count-1]);
			for(int i=0; i<totalspace; i++)
				sb.append(" ");
			res.add(sb.toString());
			return;
		}
		
		int everyspacelen = (L-wordlen)/(count-1);
		int extraspacelen = (L-wordlen)%(count-1);
		String spaces = "";
		for(int i=0; i<everyspacelen; i++)
			spaces += " ";
		
		for(int i=0; i<count-1; i++){
			sb.append(words[start+i]);
			sb.append(spaces);
			if(extraspacelen>0){
				sb.append(" ");
				extraspacelen--;
			}
		}
        sb.append(words[start+count-1]);
		res.add(sb.toString());
		
	}
}