package creationalPatterns;

public class Singleton {
    public static void main(String[] args) {

        // Eager Pattern
        SingletonEager e1 = SingletonEager.getInstance();
        SingletonEager e2 = SingletonEager.getInstance();

        System.out.println("Singleton Eager ------------------------");
        System.out.println(e1);
        System.out.println(e2);

    }
}

/// Singleton Eager Pattern
class SingletonEager {
    private static final SingletonEager singletonEager = new SingletonEager();
    private SingletonEager() {}

    public static SingletonEager getInstance(){
        return singletonEager;
    }
}

/// Singleton Static Block Pattern
class SingletonStaticBlock {
    private static final SingletonStaticBlock singletonStaticBlock;
    static {
        singletonStaticBlock = new SingletonStaticBlock();
    }
    private SingletonStaticBlock() {}

    public static SingletonStaticBlock getInstance(){
        return singletonStaticBlock;
    }
}

/// Singleton Lazy
class SingletonLazy {
    private static SingletonLazy singletonLazy = null;

    private SingletonLazy() {}

    public static SingletonLazy getInstance(){
        if (singletonLazy == null){
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
}

/// Singleton Thread Safe
class SingletonThreadSafe {
    private static SingletonThreadSafe singletonThreadSafe = null;

    private SingletonThreadSafe() {}

    public static SingletonThreadSafe getInstance(){
        synchronized (singletonThreadSafe){singletonThreadSafe = new SingletonThreadSafe();}
        return singletonThreadSafe;
    }
}

/// Singleton Double Check Lock
class SingletonDCLock {
    private static SingletonDCLock singletonDCLock = null;

    private SingletonDCLock() {}

    public static SingletonDCLock getInstance(){
        synchronized (singletonDCLock){
            if (singletonDCLock == null) {
                singletonDCLock = new SingletonDCLock();
            }
        }
        return singletonDCLock;
    }
}