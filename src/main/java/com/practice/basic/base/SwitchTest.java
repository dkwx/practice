package com.practice.basic.base;

/**
 * @author : kai.dai
 * @date : 2020-05-30 23:39
 */
public class SwitchTest {
    public enum Sex{
        MAN,
        WOMAN;
    }
    public static void main(String[] args) {
        String s ="abc";
        switch (s){
            case "a":
                System.out.println("a");
                break;
            case "abc":
                System.out.println("abc");
                break;
        }

        System.out.println("test enum");
        Sex sex = Sex.MAN;
        switch (sex){
            case MAN:
                System.out.println("i am man");
        }
    }
}
