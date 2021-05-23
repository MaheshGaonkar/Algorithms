
package dp;

import java.util.Arrays;

/**
 *
 * @author Mahesh Gaonkar
 */
public class LongestIncreasingSubsequence {
    
    public static int LIS(int[] num){
        int n = num.length;
        int[] freqCount = new int[n];
        Arrays.fill(freqCount, 1);
        int LISLength = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(num[j] < num[i]){
                    freqCount[i] = Math.max(freqCount[i], freqCount[j] + 1);
                }
            }
            LISLength = Math.max(freqCount[i], LISLength);
        }
        return LISLength;
    }
    
    public static void main(String[] args){
        int[] num = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(LIS(num));
        
        int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println(LIS(arr));
    }
}
