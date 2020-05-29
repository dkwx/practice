package com.practice.niuke.offers;

/**
 * 剑指offer
 *
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *  
 *
 * 限制：
 *
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-27 13:34
 */
public class Offers059_2 {
    class MaxQueue {
        int maxV, start, length;
        int[] arrs;

        public MaxQueue() {
            maxV = -1;
            start = 0;
            length = 0;
            arrs = new int[10000];

        }

        public int max_value() {
            if (length <= 0) {
                return -1;
            }
            if (maxV == -1) {
                for (int i = start; i < (start + length); i++) {
                    if (arrs[i] > maxV) {
                        maxV = arrs[i];
                    }
                }
            }
            return maxV;
        }

        public void push_back(int value) {
            arrs[start + length] = value;
            if (value > max_value()) {
                maxV = value;
            }
            length++;

        }

        public int pop_front() {
            if (length <= 0) {
                return -1;
            }
            int value = arrs[start];
            length--;
            start++;
            if (value == max_value() || length == 0) {
                maxV = -1;
            }
            return value;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Offers059_2().new MaxQueue());
    }
}
