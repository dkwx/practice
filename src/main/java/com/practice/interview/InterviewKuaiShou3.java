package com.practice.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : kai.dai
 * @date : 2020-06-11 23:52
 */
public class InterviewKuaiShou3 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println("Hello World!");
        String test = "1+2*3-4/2+50*3-10+6";
        int result = calculate(test);
        System.out.println(result);
    }

    public static int calculate(String str) {
        List<Character> optList = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                numberList.add(Integer.valueOf(sb.toString()));
                sb = new StringBuilder();
                optList.add(ch);
            } else {
                sb.append(ch);
            }
        }

        numberList.add(Integer.valueOf(sb.toString()));
        return calculate(numberList, optList);
    }

    public static int calculate(List<Integer> numberList, List<Character> optList) {
        List<Integer> newNumberList = new ArrayList<>();
        List<Character> newOptList = new ArrayList<>();
        boolean isSpecailOpt = false;
        for (int i = 0; i < optList.size(); i++) {
            char opt = optList.get(i);
            if (opt == '*') {
                int tempResult = numberList.get(i) * numberList.get(i + 1);
                newNumberList.add(tempResult);
                isSpecailOpt = true;
            } else if (opt == '/') {
                int tempResult = numberList.get(i) / numberList.get(i + 1);
                newNumberList.add(tempResult);
                isSpecailOpt = true;
            } else {
                newOptList.add(opt);
                if (!isSpecailOpt) {
                    newNumberList.add(numberList.get(i));
                }
                isSpecailOpt = false;
            }
        }
        if (!isSpecailOpt) {
            newNumberList.add(numberList.get(numberList.size()-1));
        }

        Integer result = null;
        for (int i = 0; i < newOptList.size(); i++) {
            char opt = newOptList.get(i);
            if (opt == '+') {
                if (null == result) {
                    result = newNumberList.get(i) + newNumberList.get(i + 1);
                } else {
                    result = result + newNumberList.get(i + 1);
                }
            } else {
                if (null == result) {
                    result = newNumberList.get(i) - newNumberList.get(i + 1);
                } else {
                    result = result - newNumberList.get(i + 1);
                }
            }

        }
        return result;

    }
}
