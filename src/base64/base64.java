package base64;

import java.io.IOException;

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

        String orgStr = "gjjfsldjfjsalkjdf;          jasdjfjsdalfj;saj";
        String encodeStr = "";
        long timeStart;
        long timeEnd;

        System.out.println("-----------encode----------");
        timeStart = System.nanoTime();
        System.out.println("timeStart:"+timeStart);
        encodeStr = Base64Utils.encode(orgStr);
        System.out.println(encodeStr);
        timeEnd = System.nanoTime();
        System.out.println("timeEnd:"+timeEnd+",count:"+(timeEnd - timeStart));

        byte[] data = orgStr.getBytes();
        timeStart = System.nanoTime();
        System.out.println("timeStart:"+timeStart);
        System.out.println(encode(data));
        timeEnd = System.nanoTime();
        System.out.println("timeEnd:"+timeEnd+",count:"+(timeEnd - timeStart));

        System.out.println("-----------decode----------");
        timeStart = System.nanoTime();
        System.out.println("timeStart:"+timeStart);
        System.out.println(Base64Utils.decode(encodeStr));
        timeEnd = System.nanoTime();
        System.out.println("timeEnd:"+timeEnd+",count:"+(timeEnd - timeStart));

        timeStart = System.nanoTime();
        System.out.println("timeStart:"+timeStart);
        byte[] decodeBuff = decode(encodeStr);
        timeEnd = System.nanoTime();
        System.out.println(new String(decodeBuff));
        System.out.println("timeEnd:"+timeEnd+",count:"+(timeEnd - timeStart));
    }

    public static String encode(byte[] bstr){
        return new sun.misc.BASE64Encoder().encode(bstr);
    }

    public static byte[] decode(String str) {
        byte[] bt = null;
        try {
            sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
            bt = decoder.decodeBuffer(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bt;
    }
}
