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