package com.supengchao.github.jianzhioffer;

/**
 * Created by supengchao on 17/1/11.
 */

public class Test2 extends Base1 {
    public static void main(String[] args) {
        new Test2().method();
    }

    public void method() {
        System.err.println(this.getClass().getName());//Test2
        System.err.println(super.getClass().getName());//Test2
        System.err.println(this.getClass().getSuperclass().getName());//Base1
        System.err.println(super.getClass().getSuperclass().getName());//Base1

    }
}

class Base1 {

}
