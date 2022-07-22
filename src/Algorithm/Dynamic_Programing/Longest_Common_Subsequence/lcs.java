package Algorithm.Dynamic_Programing.Longest_Common_Subsequence;

import java.util.Arrays;

public class lcs {
    public static void main(String[] args){
        String s1= "abcde";
        String s2= "ace";

        System.out.println("The Length of Longest Common Subsequence is "+longestCommonSubsequence(s1,s2));
    }

    private static int longestCommonSubsequence(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];

        for(int[] rows: dp){
            Arrays.fill(rows,-1);
        }
        for (int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }

        for (int ind1=0;ind1<=n;ind1++){
            for (int ind2=0;ind2<=m;ind2++){
                if (s1.charAt(ind1) == s2.charAt(ind2)){

                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];

                }else{

                    dp[ind1][ind2] = Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
                }
            }
        }
        return dp[n][m];
    }
}
