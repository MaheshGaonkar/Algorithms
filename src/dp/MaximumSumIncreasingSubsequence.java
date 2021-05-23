package dp;

/**
 *
 * @author Mahesh Gaonkar
 */
public class MaximumSumIncreasingSubsequence {
    
    public static int MSIS(int[] num){
        int n = num.length;
        int[] sum = new int[n];
        System.arraycopy(num, 0, sum, 0, n);
        int maxSum = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(num[j] < num[i]){
                    sum[i] = Math.max(sum[j] + num[i], sum[i]);
                }
            }
            maxSum = Math.max(maxSum, sum[i]);
        }
        return maxSum;
    }
    
    public static void main(String[] args){
        int[] num = {1, 101, 2, 3, 100, 4, 5};
        System.out.println(MSIS(num));
    }
}
