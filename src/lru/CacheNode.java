package lru;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2018/6/26 10:02
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */
public class CacheNode<K,V> {
    public CacheNode pre;
    public CacheNode next;
    public K key;
    public V value;
}
