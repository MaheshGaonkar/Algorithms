
package dp;

/**
 *
 * @author Mahesh Gaonkar
 */
public class MinCostPath {
    
    public static int MCP(int[][] pathCost){
        int n = pathCost.length;
        int m = pathCost[0].length;
        int[][] costPathTable = new int[n][m];
        costPathTable[0][0] = pathCost[0][0];
        for(int i = 1; i < n; i++){
            costPathTable[i][0] = pathCost[i][0] + costPathTable[i - 1][0];
        }
        for(int i = 1; i < m; i++){
            costPathTable[0][i] = pathCost[0][i] + costPathTable[0][i - 1];
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                costPathTable[i][j] = pathCost[i][j] + 
                        Math.min(costPathTable[i - 1][j - 1], 
                                Math.min(costPathTable[i - 1][j], 
                                        costPathTable[i][j - 1]));
            }
        }
        return costPathTable[n - 1][m - 1];
    }
    
    public static void main(String[] args){
         int[][] A = { {1, 2, 3},
                        {4, 8, 2},
                        {1, 5, 3} };
         System.out.println(MCP(A));
         
         int[][] B = { {1, 3, 5, 8},
                        {4, 2, 1, 7},
                        {4, 3, 2, 3} };
         System.out.println(MCP(B));
    }
}
