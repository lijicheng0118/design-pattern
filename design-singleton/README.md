### 单例模式 
单例模式（Singleton Pattern）是java中最简单的设计模式之一，这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建，这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。

### 单例模式实现的三个必要条件  
1. 单例类的构造函数必须是私有的  
2. 单例类通过一个私有的静态变量来存储其唯一实例
3. 单例类通过提供一个公开的静态方法，使得外部使用者可以访问类的唯一实例

### 实现方式
饿汉式-静态成员变量
```
public class Singleton {

    /**
     * 私有构造函数
     */
    private Singleton() {

    }

    /**
     * 成员变量创建类对象
     */
    private static Singleton instance = new Singleton();

    /**
     * 对外提供访问该类对象的静态方法
     *
     * @return Singleton
     */
    public static Singleton getInstance() {
        return instance;
    }
}
```

饿汉式-静态代码块  
```
public class Singleton {

    /**
     * 私有构造函数
     */
    private Singleton() {

    }

    /**
     * 成员变量创建类对象
     */
    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    /**
     * 对外提供访问该类对象的静态方法
     *
     * @return Singleton
     */
    public static Singleton getInstance() {
        return instance;
    }
}
```

懒汉式-线程不安全  
```
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
```

懒汉式-线程安全  
synchronized加在方法体上，每调用一次方法都会进行加锁，正常是在第一次生成单例对象的时候才需要加锁，后续调用再进行加锁是对系统资源的浪费  
```
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
```

懒汉式-双重校验锁  
```
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
```

懒汉式-静态内部类  
```
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
```

枚举  
可以避免反射破坏单例模式
```
public enum Singleton {
    /**
     * INSTANCE
     */
    INSTANCE
}
```