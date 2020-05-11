package com.practice.leetcode;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00050 {


    class Solution {
        public double myPow(double x, int n) {
            // return Math.pow(x, n);
            return n >= 0 ? myPow2(x, n) : 1 / myPow2(x, -n);
        }

        double myPow2(double x, int n) {
            int N = n;
            if (N == 0) {
                return 1;
            }
            double y = myPow2(x, N / 2);
            return N % 2 == 0 ? y * y : y * y * x;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00050().new Solution();
        System.out.println(solution.myPow(2, 10));
    }
}
