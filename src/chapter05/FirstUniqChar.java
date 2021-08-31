package chapter05;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 剑指 Offer 50.
 * 第一个只出现一次的字符
 *
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class FirstUniqChar {
    /**
     * O(n) O(256) 空间复杂度为1-256，如果只有大小写字母的话值更小。
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        if (s.length() == 0) {
            return ' ';
        }
        HashMap<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int[] value = map.getOrDefault(ch, new int[]{0, i});
            value[0]++;
            map.put(ch, value);
        }
        char ans = ' ';
        int min = s.length();
        for (char ch : map.keySet()) {
            int[] value = map.get(ch);
            if (value[0] == 1) {
                if (min > value[1]) {
                    min = value[1];
                    ans = ch;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().firstUniqChar("abaccdeff"));
        System.out.println(new FirstUniqChar().firstUniqChar("abcdabcde"));
        System.out.println(new FirstUniqChar().firstUniqChar("abcdabcdee"));
    }
}
