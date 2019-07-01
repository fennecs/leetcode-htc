/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s.equals("")){
            return "";
        }
        int length = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        int[] array = new int[length];
        int maxLen = 0, maxIndex = 0;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= 0; j--) {
                if (s.charAt(i) == rev.charAt(j)){
                    if (i == 0 || j == 0 ){
                        array[j] = 1;
                    }else{
                        array[j] = array[j-1] + 1;
                    }
                } else {
                    // 二维数组如果不是匹配的会
                    array[j] = 0;
                }
                if (array[j] > maxLen){
                    int originIndex = length - 1 - j;
                    // 如果是回文串，那么j的原下标加上最大子串长度，会等于字串末尾下标
                    if (originIndex + array[j] - 1  == i) {
                        maxIndex = i;
                        maxLen = array[j];                    
                    }
                }
            }
        }
        return s.substring(maxIndex - maxLen + 1, maxIndex + 1);
    }
}