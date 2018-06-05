package base64;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2018/6/5 20:49
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */
public class base64 {

    public static void main(String[] s) {
        System.out.println(getBitStr('r'));
    }


    public static void code64(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
             s.charAt(i);
        }
    }

    public static String getBitStr(char i) {
        int ascii = (int) i;
        //其中0表示补零而不是补空格，8表示至少8位
        return String.format("%08d",Integer.toBinaryString(ascii));
    }
}
