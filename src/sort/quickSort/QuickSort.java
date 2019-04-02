package sort.quickSort;

import sort.bubbleSort.BubbleSort;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2018/7/4 16:40
 *     desc  :
 *     thanks To:
 *          1.  https://blog.csdn.net/man_sion/article/details/70138747
 *          2.  https://juejin.im/post/5a5416e9f265da3e5a571f39#heading-6
 *     dependent on:
 *     update log:
 * </pre>
 */
public class QuickSort {

    private static int[] old = {
            1, 2, 3, 21, 234
    };

    public static void main(String[] strings) {

        int[] a = old;
        long start = System.nanoTime();
        _quickSort(a, 0, a.length-1);
        System.out.println("quickSort,use:"+(System.nanoTime()-start));
        for (int anA : a) {
            System.out.print(anA + ",");
        }

        System.out.println();
        int[] b = old;
        start = System.nanoTime();
        BubbleSort.optimizationBubbleSort(b);
        System.out.println("bubbleSort,use:"+(System.nanoTime()-start));
        for (int anA : b) {
            System.out.print(anA + ",");
        }
    }

    /**
     * 快速排序
     * @param a 数组
     * @param l 右边index
     * @param r 左边index
     */
    private static void _quickSort(int[] a, int l, int r) {
        //如果l >= r 说明已经拍好序列了
        if (l < r) {
            int leftIndex = l;
            int rightIndex = r;
            int baseNum = a[l];//基准数
            while (leftIndex<rightIndex) {
                //右边开始，寻找小于基准数，找到则填入基准数原来的位置上
                while (leftIndex < rightIndex && a[rightIndex]>=baseNum)
                    rightIndex--;
                if (leftIndex<rightIndex)
                    a[leftIndex++] = a[rightIndex];
                //左边开始，寻找大于基准数，找到则填入基准数原来的位置上
                while(leftIndex < rightIndex && a[leftIndex] <= baseNum)
                    leftIndex++;
                if(leftIndex < rightIndex)
                    a[rightIndex--] = a[leftIndex];
            }
            a[leftIndex] = baseNum;
            _quickSort(a, l, leftIndex - 1);
            _quickSort(a, leftIndex + 1, r);
        }
    }
}
