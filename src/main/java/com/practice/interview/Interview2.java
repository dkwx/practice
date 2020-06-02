package com.practice.interview;

/**
 *
 *
 * @author : kai.dai
 * @date : 2020-06-01 12:45
 */
public class Interview2 {

        public static void main(String[] args) {
            //Scanner in = new Scanner(System.in);
            //int a = in.nextInt();
            //System.out.println(a);
            System.out.println("Hello World!");
            System.out.println(multi("10000000000","200000000000"));
        }

        public static String multi(String s1, String s2){
            int length =s1.length();
            String[] strs = new String[length];
            String append ="";
            for(int i = length-1 ;i >=0;i--){
                Integer number = Integer.valueOf(s1.charAt(i)+"");
                String temp = getMulti(number,s2);
                temp+=append;
                append+="0";
                strs[i]=temp;
            }
            return mergeStrs(strs);
        }
        public static String mergeStrs(String[] strs){
            int length = strs.length;
            String preStr = strs[length-1];
            for(int i = length-2 ;i >=0;i--){
                String currStr = strs[i];
                preStr = mergeStrs(preStr,currStr);
            }
            return preStr;
        }

        public static String mergeStrs(String preStr,String currStr){
            int preStrL = preStr.length();
            int currStrL = currStr.length();
            int leftNumber = 0;
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < preStrL;i++ ){
                int preInt = Integer.valueOf(preStr.charAt(preStrL-i-1)+"");
                int currInt=0;
                if(i<currStrL){
                    currInt= Integer.valueOf(currStr.charAt(currStrL-i-1)+"");
                }
                int tempResult = preInt+currInt+leftNumber;
                int rInt = tempResult %10;
                leftNumber = tempResult/10;
                sb.append(rInt);
            }
            return sb.reverse().toString();

        }


        public static String getMulti(int number, String s2){
            StringBuilder sb = new StringBuilder();
            int length =s2.length();
            int div = 0;
            for(int i=length-1;i>=0;i-- ){
                int sNumber = Integer.valueOf(s2.charAt(i)+"");
                int tempResult = sNumber*number+div;
                int mod = tempResult%10;
                div = tempResult/10;
                sb.append(mod);
            }
            sb.append(div);
            return sb.reverse().toString();
        }

}
