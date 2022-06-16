package io.split.tutorial.repository;

import com.ferrovial.architecture.split.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    public static final String ROLE = "role";
    public static final String TEST = "test";
    public static final String USER = "user";
    public static final String BROWSER = "browser";
    public static final String EDGE = "edge";
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String OPERA = "opera";
    public static final String SAFARI = "safari";
    private final List<User> users = List.of(
            new User("Francisco", Map.of(ROLE, TEST, BROWSER, EDGE)),
            new User("Jorge", Map.of(ROLE, TEST, BROWSER, CHROME)),
            new User("Juan", Map.of(ROLE, TEST, BROWSER, FIREFOX)),
            new User("Maria", Map.of(ROLE, USER, BROWSER, OPERA)),
            new User("Marta", Map.of(ROLE, USER, BROWSER, SAFARI)),
            new User("Noelia", Map.of(ROLE, USER, BROWSER, CHROME)),
            new User("Alberto", Map.of(ROLE, USER, BROWSER, SAFARI)),
            new User("Lucas", Map.of(ROLE, USER, BROWSER, CHROME)),
            new User("Sandra", Map.of(ROLE, USER, BROWSER, FIREFOX)),
            new User("Mario", Map.of(ROLE, USER, BROWSER, EDGE)));

    public List<User> findAll(){
        return users;
    }
}
