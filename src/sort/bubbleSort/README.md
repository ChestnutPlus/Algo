### 总结：
- 时间复杂度：
        N个元素最坏的情况下，是逆序，那么，
            第一次需要比较 N-1 次 ， 得出第一个最大值
            第二次需要比较 N-2 次 ， 得出第二个最大值
            。。。
            所以，
            复杂度 T(n) = (n-1) + (n-2) + (n-3) + ... + 1 = O(n^2)

- 空间复杂度
        算法进行的时候，额外新增了一个或者两个变量，所以，
            空间复杂度为：O(2) = O(1)
- 稳定性
        在代码中，由核心比较的：if (arr[j]>arr[j+1])
        得出，当相同的两个元素比较的时候，
        并没有替换，所以，冒泡排序是稳定的。

````java
/**
 * 简单的冒泡排序，
 *  没有做任何的优化
 *  小数放在0，大数放在第N。
 *
 * @param arr   待排序数组
 */
private static void simpleBubbleSort(int[] arr) {
    int temp;
    //每一趟把最大的数沉底
    for (int i = arr.length - 1; i > 0; i--) {
        for (int j = 0; j < i; j++) {
            if (arr[j]>arr[j+1]) {
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}

/**
 * 优化的冒泡排序
 *  如果，本来传入的
 *  数组就已经有顺序了，
 *  那么我们原本的算法
 *  就显得多于，因为也要比较这么多次，
 *  所以这里引入一个布尔变量去做优化。
 *
 * @param arr   待排序数组
 */
private static void optimizationBubbleSort(int[] arr) {
    int temp;
    boolean isNotSorted = false;
    //每一趟把最大的数沉底
    for (int i = arr.length - 1; i > 0; i--) {
        isNotSorted = false;
        for (int j = 0; j < i; j++) {
            if (arr[j]>arr[j+1]) {
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                isNotSorted = true;
            }
        }
        if (!isNotSorted) {
            break;
        }
    }
}
````
