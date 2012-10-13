public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int len1 = word1.length()+1;
        int len2 = word2.length()+1;
        
        if(len1 ==1) return len2-1;
        if(len2 ==1) return len1-1;
        
        int[][] mat = new int[len1][len2];
        
        
        for(int i=0; i<len2; i++){
            mat[0][i] = i;
        }
        
        for(int i=0; i<len1; i++){
            mat[i][0] = i;
        }
        
        
        
        for(int i=1; i<len1; i++)
            for(int j=1; j<len2; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    mat[i][j] = mat[i-1][j-1];
                }
                else{
                    mat[i][j] = Math.min(mat[i-1][j-1],Math.min(mat[i-1][j], mat[i][j-1]))+1;
                }
            }
        
        return mat[len1-1][len2-1];
        
        
    }
}