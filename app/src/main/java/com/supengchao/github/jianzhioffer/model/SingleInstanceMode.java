package com.supengchao.github.jianzhioffer.model;

/**
 * Created by supengchao on 17/2/15.
 *
 * 7种单例模式的写法，建议使用第5中，静态内部类的单例模式
 */

public class SingleInstanceMode {


    public static void main(String[] args) {
        System.out.println(SingleInstanceMode.getInstance().toString());
        System.out.println(SingleInstanceMode.getInstance().toString());
    }

    //---------------------------方式1-------------------------
    private static SingleInstanceMode instance;

    public static SingleInstanceMode getInstance1() {
        if (instance == null) {
            instance = new SingleInstanceMode();
        }
        return instance;
    }
    //---------------------------方式2-------------------------

    private static SingleInstanceMode instace2;

    public static synchronized SingleInstanceMode getInstace2() {
        if (instace2 == null) {
            instace2 = new SingleInstanceMode();
        }
        return instace2;
    }


    //---------------------------方式3-------------------------
    private static SingleInstanceMode instance4 = new SingleInstanceMode();

    public static SingleInstanceMode getInstance4() {
        return instance4;
    }

    //---------------------------方式4-------------------------
    private static SingleInstanceMode instance5;

    static {
        instance5 = new SingleInstanceMode();
    }

    public static SingleInstanceMode getInstance5() {
        return instance5;
    }

    //---------------------------方式5-------------------------
    private SingleInstanceMode() {
    }

    private static class SingleInstanceModeHolder {
        private static final SingleInstanceMode instance = new SingleInstanceMode();
    }

    public static SingleInstanceMode getInstance() {
        return SingleInstanceModeHolder.instance;
    }

    //---------------------------方式6-------------------------
    public enum SingleInstance {
        INSTANCE;
    }
    //---------------------------方式7-------------------------

    private static volatile SingleInstanceMode instance7;

    public static SingleInstanceMode getInstance7() {
        if (instance7 == null) {
            synchronized (SingleInstanceMode.class) {
                if(instance7 == null){
                    instance7= new SingleInstanceMode();
                }
            }
        }
        return instance7;
    }
}
