package org.jicheng.design.singleton.demo04;

/**
 * 懒汉式
 * 线程安全
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
     * 添加synchronized关键字，解决线程安全问题，但是在方法上面添加之后，该方法的性能降低
     *
     * @return Singleton
     */
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
