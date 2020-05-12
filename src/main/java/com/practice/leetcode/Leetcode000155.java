package com.practice.leetcode;

import java.util.Arrays;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * <p>push(x) —— 将元素 x 推入栈中。 pop() —— 删除栈顶的元素。 top() —— 获取栈顶元素。 getMin() —— 检索栈中的最小元素。
 *
 * <p>示例:
 *
 * <p>输入： ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * <p>输出： [null,null,null,null,-3,null,0,-2]
 *
 * <p>解释： MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0);
 * minStack.push(-3); minStack.getMin(); --> 返回 -3. minStack.pop(); minStack.top(); --> 返回 0.
 * minStack.getMin(); --> 返回 -2.
 *
 * <p>提示：
 *
 * <p>pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode000155 {

    class MinStack {
        Integer min = null;
        int[] arr;
        int start;
        int currEnd;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            arr = new int[8];
            start = 0;
            currEnd = 0;
        }

        public void push(int x) {
            if (currEnd == arr.length - 1) {
                arr = Arrays.copyOf(arr, arr.length * 2);
            }
            arr[currEnd] = x;
            if (min == null) {
                min = getMin();
            }
            min = min > x ? x : min;
            currEnd++;
        }

        public void pop() {
            currEnd--;
            min = null;
        }

        public int top() {
            return arr[currEnd - 1];
        }

        public int getMin() {
            if (min != null) {
                return min;
            } else {
                int temp = arr[start];
                for (int i = start; i < currEnd; i++) {
                    if (temp > arr[i]) {
                        temp = arr[i];
                    }
                }
                min = temp;
            }
            return min;
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such: MinStack obj = new MinStack();
     * obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4 = obj.getMin();
     */
    public static void main(String[] args) {
        MinStack solution = new Leetcode000155().new MinStack();
        solution.push(-2);
        solution.push(0);
        solution.push(-3);
        int result = solution.getMin();
        System.out.println(result);
        solution.pop();
        result = solution.top();
        System.out.println(result);
        result = solution.getMin();
        System.out.println(result);
        // System.out.println(solution.jump(new int[]{1, 2}));
    }
}
