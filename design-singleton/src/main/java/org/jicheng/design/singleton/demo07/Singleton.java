package org.jicheng.design.singleton.demo07;

/**
 * 饿汉式
 * 枚举类型是线程安全的，并且只会装载一次
 * 枚举类型是所用单例实现中唯一一种不会被破坏的单例实现模式
 *
 * @author Jicheng Li
 * @version v1.0
 * @date 2022/2/9 12:07
 */
public enum Singleton {
    /**
     * INSTANCE
     */
    INSTANCE
}
