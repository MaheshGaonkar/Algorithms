
package dp;

import java.util.Arrays;

/**
 *
 * @author Mahesh Gaonkar
 */
public class LongestCommonSubsequence {
    
    
    public static int LCS(String A, String B){
        int nA = A.length();
        int nB = B.length();
        
        int[][] LCSTable = new int[nB + 1][nA + 1];
        for(int i = 0; i <= nB; i++)
            Arrays.fill(LCSTable[i], 0);
        
        for(int i = 0; i < nB; i++){
            for(int j = 0; j < nA; j++){
                if(A.charAt(j) == B.charAt(i)){
                    LCSTable[i + 1][j + 1] = LCSTable[i][j] + 1; 
                }else{
                    LCSTable[i + 1][j + 1] = Math.max(LCSTable[i + 1][j], LCSTable[i][j + 1]);
                }
            }
        }
        return LCSTable[nB][nA];
    }
    
    public static void main(String[] args){
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println(LCS(X,Y));
        
        String A = "ABCDGH";
        String B = "AEDFHR";
        System.out.println(LCS(A,B));
        
        String C = "AGGTAB";
        String D = "GXTXAYB";
        System.out.println(LCS(C,D));
    }
}
