package chapter_2_create_destroy_objects.use_static_fabric;

import chapter_2_create_destroy_objects.use_static_fabric.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    @Test
    void testFrom() {
        User user = User.from("Alice", 25);
        assertThat(user).isNotNull();
        assertThat(user.toString()).isEqualTo("User{username='Alice', age=25}");
    }

    @Test
    void testOf() {
        User user = User.of("Bob");
        assertThat(user).isNotNull();
        assertThat(user.toString()).isEqualTo("User{username='Bob', age=0}");
    }

    @Test
    void testValueOf() {
        User user = User.valueOf("Charlie:30");
        assertThat(user).isNotNull();
        assertThat(user.toString()).isEqualTo("User{username='Charlie', age=30}");
    }

    @Test
    void testInstance() {
        User user = User.instance();
        assertThat(user).isNotNull();
        assertThat(user.toString()).isEqualTo("User{username='DefaultUser', age=18}");
    }

    @Test
    void testCreate() {
        User user = User.create("David", 40);
        assertThat(user).isNotNull();
        assertThat(user.toString()).isEqualTo("User{username='David', age=40}");
    }

    @Test
    void testGetTypeAdmin() {
        User user = User.getType("admin");
        assertThat(user).isNotNull();
        assertThat(user.toString()).isEqualTo("User{username='Admin', age=30}");
    }

    @Test
    void testGetTypeGuest() {
        User user = User.getType("guest");
        assertThat(user).isNotNull();
        assertThat(user.toString()).isEqualTo("User{username='Guest', age=0}");
    }

    @Test
    void testGetTypeDefault() {
        User user = User.getType("unknown");
        assertThat(user).isNotNull();
        assertThat(user.toString()).isEqualTo("User{username='User', age=18}");
    }

    @Test
    void testNewType() {
        User user = User.newType("Eve", 35);
        assertThat(user).isNotNull();
        assertThat(user.toString()).isEqualTo("User{username='Eve', age=35}");
    }

    @Test
    void testType() {
        User user = User.type();
        assertThat(user).isNotNull();
        assertThat(user.toString()).isEqualTo("User{username='TypeUser', age=25}");
    }

}