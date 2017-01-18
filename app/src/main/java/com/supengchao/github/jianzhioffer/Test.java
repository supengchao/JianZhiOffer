package com.supengchao.github.jianzhioffer;

import java.math.BigInteger;

/**
 * Created by supengchao on 17/1/11.
 */

public class Test {
    public static void main(String[] args) {
//        new Child();

//        int i1 = 10, i2 = 10;
//        System.err.println("i1 + i2 = " + i1 + i2);
//        System.err.println("i1 - i2 = " + i1 + i2);
//        System.err.println("i1 * i2 = " + i1 * i2);
//        System.err.println("i1 / i2 = " + i1 / i2);

//        Test test = new Test();
//        test.myMethod(null);

//        double val = 11.5;
//        System.err.println(Math.round(val));
//        System.err.println(Math.floor(val));
//        System.err.println(Math.ceil(val));
//
//        String str1 = new String("abc");
//        String str2 = new String("abc");
//        System.err.println(str1.equals(str2));
//        System.err.println(str1==str2);
//
//        StringBuffer sb1 = new StringBuffer("abc");
//        StringBuffer sb2 = new StringBuffer("abc");
//        System.err.println(sb1.equals(sb2));
//        System.err.println(sb1==sb2);

//        System.err.println(  new Test().method1());//1
//        System.err.println(  new Test().method2());//2

//        System.err.println(12 - 11.9 == 0.1);//FALSE
//        System.err.println(12 - 11.9);

//        BigInteger one = new BigInteger("1");
//        BigInteger two = new BigInteger("2");
//        BigInteger three = new BigInteger("3");
//        BigInteger sum = new BigInteger("0");
//        one.add(one);
//        one.add(two);
//        one.add(three);
//        System.out.println(one.toString());
//        System.out.println("res="+one.add(two));
//
//        BigInteger bi1, bi2, bi3;
//        bi1 = new BigInteger("123");
//        bi2 = new BigInteger("50");
//        bi3 = bi1.add(bi2);
//        String str = "Result of addition is " +bi3;;
//        System.out.println( str );
    }

    public int method1() {
        int x = 1;
        try {
            return x;
        } finally {
            ++x;
        }
    }

    public int method2() {
        int x = 1;
        try {
            return x;
        } finally {
            return ++x;
        }
    }


    public void myMethod(String str) {
        System.err.println("string");
    }

    public void myMethod(Object obj) {
        System.err.println("object");
    }

   static class Parent {
        private int i = 222;

        public Parent() {
            disPlay();
        }

        public void disPlay() {
            System.out.print("i=" + i);
        }
    }

    static class Child extends Parent {
        private int i = 2;

        public Child() {
            i=22;
        }

        public void disPlay() {
            System.out.print("i=" + i);
        }
    }


}
