package org.jicheng.design.singleton.demo02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * TODO
 *
 * @author Jicheng Li
 * @version v1.0
 * @date 2022/2/9 12:08
 */
class SingletonTest {

    @Test
    void getInstance() {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        assertSame(instance, instance1);
    }
}