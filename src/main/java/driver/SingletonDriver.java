package driver;

public class SingletonDriver {
    private static SingletonDriver driver = new SingletonDriver();

    private SingletonDriver() {
    };

    public static SingletonDriver getInstance() {
        if (driver == null) {
            driver = new SingletonDriver();
        }
        return driver;
    }
}
