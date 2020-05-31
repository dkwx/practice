package com.practice.leetcode.offers;

/**
 * 剑指offer
 *
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 *  
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 *
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-27 13:34
 */
public class Offers060 {
    class Solution {
        public double[] twoSum(int n) {
            double[] init = {1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};
            if (n == 1) {
                return init;
            }
            double[] pre = init;
            for (int i = 2; i <= n; i++) {
                double[] temp = new double[6 * i - i + 1];
                for (int p1 = 0; p1 < pre.length; p1++) {
                    for (int p2 = 0; p2 < init.length; p2++) {
                        temp[p1 + p2] += pre[p1] * init[p2];
                    }

                }
                pre = temp;

            }
            return pre;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Offers060().new Solution().twoSum(2));
    }
}
