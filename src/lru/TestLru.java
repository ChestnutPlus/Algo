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

        LruCache<String, Integer> lruCache = new LruCache<>(5);

        lruCache.put("a", 12);
        lruCache.put("B", 22);
        lruCache.put("c", 23);
        lruCache.put("d", 121);
        lruCache.put("e", 435);
        lruCache.printLru();


        lruCache.put("d", 121);
        lruCache.printLru();

        lruCache.put("e", 22);
        lruCache.printLru();

        lruCache.put("g", 23);
        lruCache.printLru();

    }

}
