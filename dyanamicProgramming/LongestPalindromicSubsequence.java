
package dyanamicprogramming;

/**
 *
 * @author Mahesh Gaonkar
 */
public class LongestPalindromicSubsequence {
    
    public static int LPS(String str){
        int n = str.length();
        int[][] LISTable = new int[n][n];
        for(int i = 0; i < n; i++){
            LISTable[i][i] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < (n - i); j++){
                if(str.charAt(j) == str.charAt(i + j)){
                    LISTable[j][i + j] = LISTable[j + 1][(i + j) - 1] + 2;
                }else{
                    LISTable[j][i + j] = Math.max(LISTable[j][(i + j) - 1], LISTable[j + 1][(i + j)]);
                }
            }
        }
        return LISTable[0][n - 1];
    }
    
    public static void main(String[] args){
        int a = LPS("abccdba");
        System.out.println(a);
        int b = LPS("zxdyyz");
        System.out.println(b);
        
    }
}
