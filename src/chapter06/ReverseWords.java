package chapter06;

/**
 * 剑指 Offer 58
 */
public class ReverseWords {
    /**
     * 剑指 Offer 58 - I.
     * 翻转单词顺序
     * https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        String[] data = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = data.length - 1; i >= 0; i--) {
            if (!data[i].isEmpty()) {
                ans.append(data[i]);
                ans.append(" ");
            }
        }
        return ans.toString().trim();
    }

    /**
     * 指 Offer 58 - II.
     * 左旋转字符串
     *
     * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0,n);
    }
}
