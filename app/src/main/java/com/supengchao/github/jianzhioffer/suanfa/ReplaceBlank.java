package com.supengchao.github.jianzhioffer.suanfa;

/**
 * Created by supengchao on 16/12/1.
 * 替换空格
 * 题目：请实现一个函数，把字符串中的每个空格替换成“%20”。
 */

public class ReplaceBlank {
    public static void main(String args[]){
        String input = "i am spc";
        System.out.print(replaceBlank(input));
    }
    public  static String replaceBlank(String input){
        if(input==null)
            return null;
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)==' '){
                stringBuffer.append("%");
                stringBuffer.append("2");
                stringBuffer.append("0");
            }else{
                stringBuffer.append(String.valueOf(input.charAt(i)));
            }
        }
        return stringBuffer.toString();
    }
}
