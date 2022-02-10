package org.jicheng.design.singleton.serializable;

import org.jicheng.design.singleton.demo06.Singleton;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * 序列化测试
 *
 * @author Jicheng Li
 * @version v1.0
 * @date 2022/2/10 14:05
 */
public class SerializableTest {

    String file = "f:\\test.txt";

    @Test
    void testSerializable() throws Exception {

        Singleton instance = Singleton.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(instance);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Singleton instance1 = (Singleton) ois.readObject();

        assertSame(instance, instance1);
    }

}
