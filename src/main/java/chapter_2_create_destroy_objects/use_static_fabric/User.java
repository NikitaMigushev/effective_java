package chapter_2_create_destroy_objects.use_static_fabric;

public class User {

    private final String username;
    private final int age;

    // Приватный конструктор для предотвращения прямого создания объектов
    private User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    // Фабричный метод from
    public static User from(String username, int age) {
        return new User(username, age);
    }

    // Фабричный метод of
    public static User of(String username) {
        return new User(username, 0); // Возраст по умолчанию
    }

    // Фабричный метод valueOf
    public static User valueOf(String data) {
        // Разделяем строку вида "username:age" на части
        String[] parts = data.split(":");
        return new User(parts[0], Integer.parseInt(parts[1]));
    }

    // Фабричный метод instance
    public static User instance() {
        return new User("DefaultUser", 18); // Стандартные значения
    }

    // Фабричный метод create
    public static User create(String username, int age) {
        return new User(username, age);
    }

    // Фабричный метод getType
    public static User getType(String type) {
        switch (type.toLowerCase()) {
            case "admin":
                return new User("Admin", 30);
            case "guest":
                return new User("Guest", 0);
            default:
                return new User("User", 18);
        }
    }

    // Фабричный метод newType
    public static User newType(String username, int age) {
        return new User(username, age);
    }

    // Фабричный метод type
    public static User type() {
        return new User("TypeUser", 25);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
