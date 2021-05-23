
package dp;

/**
 *
 * @author Mahesh Gaonkar
 */
public class MinimumEditDistance {
    public static int MEDBetweenStrings(String A, String B){
        int nA = A.length();
        int nB = B.length();
        
        int[][] minEditTable = new int[nB + 1][nA + 1];
        for(int i = 0; i <= nB; i++){
            minEditTable[i][0] = i;
        }
        
        for(int i = 0; i <= nA; i++){
            minEditTable[0][i] = i;
        }
        
        for(int i = 0; i < nB; i++){
            for(int j = 0; j <nA; j++){
                if(A.charAt(j) == B.charAt(i)){
                    minEditTable[i + 1][j + 1] = minEditTable[i][j];
                }else{
                    minEditTable[i + 1][j + 1] = Math.min(minEditTable[i][j],Math.min(minEditTable[i + 1][j], minEditTable[i][j + 1])) + 1;
                }
            }
        }
        
        return minEditTable[nB][nA];
    }
    
    
    public static void main(String[] args){
        String X = "sunday";
        String Y = "saturday";
        System.out.println(MEDBetweenStrings(X,Y));
        
        
        String A = "geek";
        String B = "gesek";
        System.out.println(MEDBetweenStrings(A,B));
        
        
        
       
    }
}
