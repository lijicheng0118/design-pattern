package org.jicheng.design.singleton.reflection;

import org.jicheng.design.singleton.demo06.Singleton;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * 反射破坏单例模式
 *
 * @author Jicheng Li
 * @version v1.0
 * @date 2022/2/10 11:08
 */
public class ReflectionSingleton {

    @Test
    void testReflection() throws Exception {
        Class<Singleton> clazz = Singleton.class;
        // 通过反射获取私有构造方法
        Constructor<Singleton> declaredConstructor = clazz.getDeclaredConstructor();
        // 访问私有方法时设置为true
        declaredConstructor.setAccessible(true);
        // 初始化
        Singleton singleton = declaredConstructor.newInstance();
        Singleton singleton1 = declaredConstructor.newInstance();
        assertSame(singleton, singleton1);
    }
}
