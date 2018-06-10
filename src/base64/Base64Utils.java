package base64;

import java.lang.ref.SoftReference;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2018/6/10 16:40
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */
public class Base64Utils {

    private static final char[] baseChars = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/',
    };

    /**
     * Base64编码
     * @param s 字符串
     * @return 结果
     */
    public static String encode(String s) {
        int index = 0;
        StringBuilder strBuff = new StringBuilder();
        StringBuilder resultBuff = new StringBuilder();
        while (true) {
            //是否结束
            if (index == -1) {
                switch (s.length()*8%6) {
                    case 2:
                        resultBuff.append('=').append('=');
                        break;
                    case 4:
                        resultBuff.append('=');
                        break;
                }
                break;
            }
            //判断是否需要补零
            if (index>=s.length()) {
                int zeroCount = 6 - strBuff.length();
                for (int i = 0; i < zeroCount; i++) {
                    strBuff.append('0');
                }
                index = -1;
            }
            //更新二进制缓冲区
            if (strBuff.length()<6) {
                strBuff.append(get8BitStr(s.charAt(index++)));
            }
            //从缓冲区取6个字符出来
            String temp2 = strBuff.substring(0,6);
            int temp10 = Integer.parseInt(temp2, 2);
            resultBuff.append(baseChars[temp10]);
            strBuff.delete(0, 6);
        }
        return resultBuff.toString();
    }

    /**
     * Base64解码
     * @param s 编码好的base64
     * @return 结果
     */
    public static String decode(String s) {
        int index = 0;
        StringBuilder strBuff = new StringBuilder();
        StringBuilder resultBuff = new StringBuilder();
        while (true) {
            //补零
            if (index==s.length() || s.charAt(index)=='=') {
                int zeroCount = 8 - strBuff.length();
                for (int i = 0; i < zeroCount; i++) {
                    strBuff.append('0');
                }
                index = -1;
            }
            //更新缓冲区字符
            while (index!=-1 && strBuff.length()<8 && index<s.length()) {
                int chatIndex = getCharIndexInBaseChars(s.charAt(index++));
                strBuff.append(get6BitStr(chatIndex));
            }
            //从缓冲区取8个字符
            String temp2 = strBuff.substring(0,8);
            int temp10 = Integer.valueOf(temp2,2);
            resultBuff.append((char)temp10);
            strBuff.delete(0, 8);
            //判断是否结束
            if (index==-1)
                break;
        }
        return resultBuff.toString().trim();
    }

    /**
     * 得到某个字符，在编码表的位置
     * @param i 字符
     * @return 编号
     */
    private static int getCharIndexInBaseChars(char i) {
        int ascii = (int) i;
        if (ascii == 43) //'+'
            return 62;
        else if (ascii == 47) //'/'
            return 63;
        else if (ascii>=48 && ascii<=57) // 0-9
            return ascii+4;
        else if (ascii>=65 && ascii<=90) // A-Z
            return ascii-65;
        else if (ascii>=97 && ascii<=122) // a-z
            return ascii-71;
        else
            return -1;
    }

    /**
     * 获取对应字符的ASCII码的二级制序列
     *  八位，不足前面补零
     * @param i 字符
     * @return 二进制序列
     */
    private static String get8BitStr(char i) {
        int ascii = (int) i;
        //其中0表示补零而不是补空格，8表示至少8位
        StringBuilder s = new StringBuilder(Integer.toBinaryString(ascii));
        if (s.length()<8) {
            int zeroCount = 8 - s.length();
            for (int j = 0; j < zeroCount; j++) {
                s.insert(0, '0');
            }
        }
        return s.toString();
    }

    private static String get6BitStr(int ascii) {
        StringBuilder s = new StringBuilder(Integer.toBinaryString(ascii));
        if (s.length()<6) {
            int zeroCount = 6 - s.length();
            for (int j = 0; j < zeroCount; j++) {
                s.insert(0, '0');
            }
        }
        return s.toString();
    }
}
