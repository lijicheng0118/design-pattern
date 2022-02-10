package org.jicheng.design.singleton.demo07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * TODO
 *
 * @author Jicheng Li
 * @version v1.0
 * @date 2022/2/9 12:16
 */
class SingletonTest {

    @Test
    void getInstance() {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance1 = Singleton.INSTANCE;
        assertSame(instance, instance1);
    }

}