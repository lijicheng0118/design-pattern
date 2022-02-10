package org.jicheng.design.singleton.demo03;

/**
 * 懒汉式
 * 线程不安全
 *
 * @author Jicheng Li
 * @version v1.0
 * @date 2022/2/9 10:19
 */
public class Singleton {

    /**
     * 私有构造函数
     */
    private Singleton() {
    }

    private static Singleton instance;

    /**
     * 对外提供静态方法获取该对象
     * 在多线程环境会出现线程安全问题
     *
     * @return Singleton
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
