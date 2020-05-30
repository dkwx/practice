package com.practice.niuke.offers;

/**
 * 剑指offer
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 *  
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *  
 *
 * 提示：
 *
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-27 13:34
 */
public class Offers065 {
    class Solution {
        public int add(int a, int b) {
            if (b == 0) {
                return a;
            }
            // a^b ，不同为1，相同为0
            // a&b 都为1才是1 需要进一，所以左移
            return add(a ^ b, (a & b) << 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Offers065().new Solution().add(1, 2));
    }
}
