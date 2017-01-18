package com.supengchao.github.jianzhioffer;

/**
 * Created by supengchao on 17/1/11.
 */


public class Test1 extends Base {

    public static void main(String[] args) {
        Base b = new Test1();
        try {
            b.method();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Test1 t = new Test1();
        t.method();
    }

    @Override
    public void method() {
        System.err.println("test");
    }

}

class Base {
    public void method() throws Exception{
        System.err.println("base");
    }
}
