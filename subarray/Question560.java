package subarray;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class Question560 {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            int count = 0, curSum = 0;
            for (int j = i ; j < nums.length ; j++) {
                curSum += nums[j];
                if (curSum == k) {
                    count++;
                }
            }
            res += count;
        }
        return res;
    }
}
