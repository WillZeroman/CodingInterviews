package chapter07;

/**
 * 剑指 Offer 67. 把字符串转换成整数
 * https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 */
public class StrToInt {
    public int strToInt(String str) {
        if (str == null) {
            return 0;
        }
        String data = str.trim();
        if (data.length() == 0) {
            return 0;
        }
        int sign = 1;
        char fisrtChar = data.charAt(0);
        int index = 0;
        if (fisrtChar == '+') {
            sign = 1;
            index++;
        } else if (fisrtChar == '-') {
            sign = -1;
            index++;
        }

        int res = 0;
        for (int i = index; i < data.length(); i++) {
            char ch = data.charAt(i);
            if (ch > '9' || ch < '0') {
                break;
            }
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (ch - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (ch - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            res *=10;
            res +=(sign * (ch -'0'));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new StrToInt().strToInt(String.valueOf(Integer.MAX_VALUE-1)));
        System.out.println(new StrToInt().strToInt(String.valueOf(Integer.MIN_VALUE+1)));
    }
}
