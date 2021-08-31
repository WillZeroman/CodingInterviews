package chapter05;

import java.util.HashMap;

/**
 * 剑指 Offer 48.
 * 最长不含重复字符的子字符串
 *
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class LengthOfLongestSubstring {
    /**
     * O(n) O(n)
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                ans = Math.max(i - startIndex, ans);
                int index = map.get(ch);
                startIndex = Math.max(startIndex, index + 1);
            }
            map.put(ch, i);
        }
        ans = Math.max(ans, s.length() - startIndex);

        return ans;
    }
    public int lengthOfLongestSubstring_best2(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                int index = map.get(ch);
                startIndex = Math.max(index,startIndex);
            }
            map.put(ch, i);
            ans = Math.max(ans,i-startIndex);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcde"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring_best2("abcabcde"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcde"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabccc"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("cdd"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("aaaa"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abba"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring_best2("abba"));
    }
}
