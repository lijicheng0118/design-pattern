package org.jicheng.design.singleton.demo06;

/**
 * 懒汉式
 * 第一次加载Singleton类时不会去初始化INSTANCE，只有第一次调用getInstance，虚拟机加载SingletonHolder
 * 并初始化INSTANCE，这样不仅能确保线程安全，也能保证 Singleton 类的唯一性
 * 在没有加任何锁的情况下，保证了多线程下的安全，并且没有任何性能影响和空间的浪费
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

    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }

    /**
     * 对外提供静态方法获取该对象
     *
     * @return Singleton
     */
    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

}
