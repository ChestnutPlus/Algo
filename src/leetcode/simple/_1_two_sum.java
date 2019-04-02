package leetcode.simple;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2018/7/13 18:01
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */

/**
 https://leetcode-cn.com/problems/two-sum/description/
 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

 示例:
 给定 nums = [2, 7, 11, 15], target = 9
 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]

 */

public class _1_two_sum {

    public static void main(String[] args) {
//        int[] a = new int[]{
//                2, 7, 11, 15
//        };//9

//        int[] a = new int[]{
//                -3, 4, 3, 90
//        };//7

//        int[] a = new int[]{
//                0, 4, 3, 0
//        };//0

        int[] a = new int[]{
                -3, 4, 3, 90
        };//0

        int[] b = twoSum(a, 0);
        for (int aB : b) {
            System.out.print(aB + ",");
        }
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        for (int j = nums.length-1; j >0; j--) {
            for (int i = 0; i < j; i++) {
                if (nums[i]+nums[j]==target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
