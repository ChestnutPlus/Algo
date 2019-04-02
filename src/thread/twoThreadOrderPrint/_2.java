package thread.twoThreadOrderPrint;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2018/8/21 10:12
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */
public class _2 {

    public static void main(String[] args) {

        float start = -236;
        float end = 303;

        float x1 = 5;
        float y1= -236;

        float x2 = 13;
        float y2 = 303;

        x1 *= 0.01f;
        x2 *= 0.01f;

        y1 = (y1 - start) / (end - start);
        y2 = (y2 - start) / (end - start);

        System.out.println("("+x1+" , "+y1+") \n" + "("+x2+" , "+y2+")");

        float k = (y2-y1) / (x2-x1);
        float b = y2 - k * x2;

        System.out.println("y = kx + b");
        System.out.println("y = " + k  +"f * v "+ (b>0?"+ " + b :"- " + -b) + "f" );
    }

    private static int getInt1() {
        try {
            int a = 10/0;
            System.out.println("1");
            return 1;
        } catch (Exception e) {
            System.out.println("catch");
            return 2;
        } finally {
            System.out.println("finally");
            return 3;
        }
    }

    private static int getInt2() {
        try {
            int a = 10/0;
            System.out.println("1");
            return 1;
        } catch (Exception e) {
            System.out.println("catch");
            return 2;
        } finally {
            System.out.println("finally");
        }
    }

    private static int getInt3() {
        try {
            int a = 10/0;
            System.out.println("1");
            return 1;
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
        return 2;
    }
}
