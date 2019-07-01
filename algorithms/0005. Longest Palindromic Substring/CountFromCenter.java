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
        int start=0,end = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            // 奇数
            int len1 = countCenter(s, i, i);
            // 偶数
            int len2 = countCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            // 这里也可以是 len > start - end
            if (len >= end - start + 1){
                // (len -1 ) / 2 表示长度是偶数时，i是偏左的，所以要start - 1，end不用
                // 当长度是奇数时，(len -1 ) / 2和 len/2是相等的
                start = i - (len -1 ) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end+1);
    }

    /**
     * 返回最长对称串的长度
     * @param s
     * @param start
     * @param end
     * @return
     */
    public int countCenter(String s, int start, int end){
        int length = s.length();
        while (start >= 0 && end < length && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        };
        // -1 因为最后一个循环的原因 start多减一次，end多加一次，再加算长度要加1
        // 所以是 return end - start - 2 + 1
        return end - start - 1;
    }
}

