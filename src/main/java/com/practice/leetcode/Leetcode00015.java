package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00015 {


    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return result;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int target = -nums[i];
                int leftPointer = i + 1, rightPointer = nums.length - 1;
                while (leftPointer < rightPointer) {
                    int leftV = nums[leftPointer];
                    int rightV = nums[rightPointer];
                    if (leftV + rightV == target) {
                        result.add(Arrays.asList(nums[i], leftV, rightV));
                        while (leftPointer < nums.length - 1 && leftV == nums[leftPointer + 1]) {
                            leftPointer++;
                        }
                        while (rightPointer > 0 && rightV == nums[rightPointer - 1]) {
                            rightPointer--;
                        }
                        leftPointer++;
                        rightPointer--;
                    } else if (leftV + rightV < target) {
                        leftPointer++;
                    } else {
                        rightPointer--;
                    }
                }

            }
            return result;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00015().new Solution();
        System.out.println(solution.threeSum(new int[]{0, 0, 0}));
    }
}
