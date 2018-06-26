package lru;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
public class LruCache<K, V> {

    private int curSize = 10;
    private HashMap<K, CacheNode> cacheNodes;
    private CacheNode firstNode;

    public LruCache(int curSize) {
        this.curSize = curSize;
        cacheNodes = new HashMap<>();
    }

    /**
     * 尝试获取一个缓存值
     *  没有则返回null
     * @param k key
     * @return value
     */
    public CacheNode get(K k) {
        return cacheNodes.get(k);
    }

    public V getValue(K k) {
        return (V) cacheNodes.get(k).value;
    }

    /**
     * 插入一个数据
     * @param k key
     * @param v value
     */
    public void put(K k, V v) {
        CacheNode temp = get(k);
        //没有，则直接插入
        if (temp==null) {
            CacheNode<K,V> tempNode = new CacheNode<>();
            tempNode.key = k;
            tempNode.value = v;
            cacheNodes.put(k, tempNode);
            if (firstNode==null) {
                firstNode = tempNode;
            }
            else {
                tempNode.next = firstNode;
                tempNode.pre = null;
                firstNode.pre = tempNode;
                firstNode = tempNode;
            }
            //判断是否已经超出容量
            if (cacheNodes.size()>curSize) {
                CacheNode<K,V> theLastCacheNode = firstNode;
                for (;;) {
                    if (theLastCacheNode.next==null) {
                        break;
                    }
                    theLastCacheNode = theLastCacheNode.next;
                }
                int removeCount = cacheNodes.size() - curSize;
                for (int i = 0; i < removeCount; i++) {
                    cacheNodes.remove(theLastCacheNode.key);
                    theLastCacheNode = theLastCacheNode.pre;
                }
                theLastCacheNode.next = null;
            }
        }
        //有，取出到最前端
        else {
            CacheNode pre = temp.pre;
            CacheNode next = temp.next;
            if (pre!=null && next!=null) {
                pre.next = next;
                next.pre = pre;
            }
            temp.next = firstNode;
            temp.pre = null;
            firstNode.pre = temp;
            firstNode = temp;
        }
    }

    public void printLru() {
        CacheNode temp = firstNode;
        for (;;) {
            if (temp!=null) {
                System.out.print(String.valueOf(temp.key)+"-"+String.valueOf(temp.value));
                System.out.print(",");
                temp = temp.next;
            }
            else {
                System.out.println();
                break;
            }
        }
    }
}
