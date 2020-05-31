package com.practice.basic.base.exception;

/**
 * @author : kai.dai
 * @date : 2020-05-31 12:45
 */
public class TException<T> extends Object {
    // public class TException<T> extends Exception {
    // 错误:(7, 36) java: 泛型类不能扩展 java.lang.Throwable
    public static void main(String[] args) {
        // try{
        //     if(true){
        //         throw new TException<Integer>();
        //     }else {
        //         throw new TException<String>();
        //     }
        // }catch (TException<Integer> e){
        //     System.out.println("捕获integer");
        // }catch (TException<String> e){
        //     System.out.println("捕获String");
        // }
    }
}
