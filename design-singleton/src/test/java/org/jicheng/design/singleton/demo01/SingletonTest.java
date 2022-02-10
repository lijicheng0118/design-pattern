package org.jicheng.design.singleton.demo01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * 单元测试
 *
 * @author Jicheng Li
 * @version v1.0
 * @date 2022/2/9 10:15
 */
class SingletonTest {

    @Test
    void getInstance() {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        assertSame(instance, instance1);
    }
}