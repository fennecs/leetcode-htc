/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */
class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        // 和最长自串一样，我们第二层for遍历的时候，p[i][j] = p[i+1][j-1] && S[i] == S[j], 这时j在变化，i是不变的
        boolean[] dp = new boolean[length];
        String result = "";
        for (int i = length - 1; i >= 0; i--) {
            for (int j = length -1; j >= i ; j--){
                int len = j - i + 1;
                dp[j] = (len < 3 || dp[j-1]) && s.charAt(i) == s.charAt(j);
                if (dp[j] && len > result.length()){
                    result = s.substring(i, j + 1);
                }  
            }
        }
        return result;
    }
}

