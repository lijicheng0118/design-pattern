package org.jicheng.design.singleton.demo05;

/**
 * 懒汉式
 * 线程安全(双重检查锁）
 * 双重检查锁模式是一种非常好的单例实现模式，解决了单例、性能、线程安全问题
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

    /**
     * 此处注意引用需要用volatile修饰，防止指令重排序
     */
    private static volatile Singleton instance;

    /**
     * 对外提供静态方法获取该对象
     * 添加synchronized关键字，解决线程安全问题，但是在方法上面添加之后，该方法的性能降低
     *
     * @return Singleton
     */
    public static Singleton getInstance() {
        // 第一次判断如果instance不为null直接返回实例
        if (instance == null) {
            synchronized (Singleton.class) {
                // 第二次判断instance是否为null
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
