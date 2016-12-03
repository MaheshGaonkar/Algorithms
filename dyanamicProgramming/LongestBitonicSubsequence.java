
package dyanamicprogramming;

import java.util.Arrays;

/**
 *
 * @author Mahesh Gaonkar
 */
public class LongestBitonicSubsequence {
    
    public static int LBS(int[] num){
        int n = num.length;
        int[] freqCountIncr = new int[n];
        int[] freqCountDecr = new int[n];
        Arrays.fill(freqCountIncr, 1);
        Arrays.fill(freqCountDecr, 1);
        
        LISIncr(num,freqCountIncr);
        System.out.println();
        LISDecr(num,freqCountDecr);
        
        
        
        int LISLength = freqCountIncr[0] + freqCountDecr[0] - 1;
        for(int i = 1; i < n; i++){
            LISLength = Math.max(LISLength, freqCountIncr[i] + freqCountDecr[i] - 1);
        }
        return LISLength;
    }
    
    private static void LISIncr(int[] num, int[] freqCount){
        int n = num.length;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(num[j] < num[i]){
                    freqCount[i] = Math.max(freqCount[i], freqCount[j] + 1);
                }
            }
        }
    }
    
    private static void LISDecr(int[] num, int[] freqCount){
        int n = num.length;
        for(int i = n - 2; i >= 0; i--){
            for(int j = n - 1; j > i; j--){
                if(num[j] < num[i]){
                    freqCount[i] = Math.max(freqCount[i], freqCount[j] + 1);
                }
            }
        }
    }
    
    public static void main(String[] args){
        int[] num = {12, 11, 40, 5, 3, 1};
        System.out.println(LBS(num));
        
        int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println(LBS(arr));
    }
    
}
