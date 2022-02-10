package org.jicheng.design.singleton.demo01;

/**
 * 饿汉式
 * 静态成员变量创建类对象
 *
 * @author Jicheng Li
 * @version v1.0
 * @date 2022/2/9 10:01
 */
public class Singleton {

    /**
     * 私有构造函数
     */
    private Singleton() {

    }

    /**
     * 成员变量创建类对象
     */
    private static Singleton instance = new Singleton();

    /**
     * 对外提供访问该类对象的静态方法
     *
     * @return Singleton
     */
    public static Singleton getInstance() {
        return instance;
    }
}
