package com.practice.leetcode.offers;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指offer
 *
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 * 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-27 13:34
 */
public class Offers059_1 {
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0) {
                return new int[0];
            }
            int[] result = new int[nums.length - k + 1];
            // 只保留上一个数和比上一个数大或相等的
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                // 先把开头的删掉
                if (i >= k && deque.peekFirst() == nums[i - k]) {
                    deque.removeFirst();
                }
                while (!deque.isEmpty()) {
                    if (deque.getLast() < num) {
                        deque.removeLast();
                    } else {
                        break;
                    }

                }
                deque.add(num);

                if (i >= (k - 1)) {
                    result[i - k + 1] = deque.peekFirst();
                }
            }
            return result;

        }
    }

    public static void main(String[] args) {
        System.out.println(new Offers059_1().new Solution().maxSlidingWindow(new int[]{7, 2, 4}, 2));
    }
}
