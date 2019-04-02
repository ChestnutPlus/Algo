package lru;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2018/6/26 10:37
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */
public class TestLru {

    public static void main(String[] args) {

//        LruCache<String, Integer> lruCache = new LruCache<>(5);
//
//        lruCache.put("a", 12);
//        lruCache.put("B", 22);
//        lruCache.put("c", 23);
//        lruCache.put("d", 121);
//        lruCache.put("e", 435);
//        lruCache.printLru();
//
//
//        lruCache.put("d", 121);
//        lruCache.printLru();
//
//        lruCache.put("e", 22);
//        lruCache.printLru();
//
//        lruCache.put("g", 23);
//        lruCache.printLru();


        String content = "栗子是一个大帅哥";
        String subStr = "栗子";
        String subStr2 = "一个";
        System.out.println(content.indexOf(subStr));
        System.out.println(content.indexOf(subStr2));

    }

    /**
     * 分割数组
     * @param arr 原数组
     * @param m 分割个数
     * @return 结果
     */
    private static int[][] Test(int[] arr, int m) {
        if (arr==null || m > arr.length)
            return null;
        else {
            int[][] result = new int[m][];
            int everyArrCount = arr.length / m;
            for (int i = 0; i < m; i++) {
                int count = 0;
                if (i!=m-1) {
                    count = everyArrCount;
                }
                else {
                    count = arr.length-everyArrCount*i;
                }
                result[i] = new int[count];
                for (int j = 0; j < count; j++) {
                    result[i][j] = arr[i*everyArrCount+j];
                }
            }
            return result;
        }
    }
}
