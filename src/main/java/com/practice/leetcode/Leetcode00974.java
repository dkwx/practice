package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 *  
 *
 * 示例：
 *
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00974 {


    class Solution {
        public int subarraysDivByK(int[] A, int K) {
            Map<Integer, Integer> modMap = new HashMap<>();
            modMap.put(0, 1);
            int sum = 0;
            for (int t : A) {
                sum += t;
                int mod = ((sum % K) + K) % K;
                modMap.put(mod, modMap.getOrDefault(mod, 0) + 1);
            }
            int result = 0;
            for (int r : modMap.values()) {
                result += r * (r - 1) / 2;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00974().new Solution();
        System.out.println(solution.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }
}
