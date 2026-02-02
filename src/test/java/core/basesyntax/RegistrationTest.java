package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import core.basesyntax.exception.InvalidUserRegistration;
import core.basesyntax.model.User;
import core.basesyntax.service.RegistrationService;
import core.basesyntax.service.RegistrationServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Feel free to remove this class and create your own.
 */
public class RegistrationTest {
    private static RegistrationService registrationService;
    private static User user;

    @BeforeAll
    public static void testRegistration() {
        registrationService = new RegistrationServiceImpl();
    }

    @BeforeEach
    public void beforeEach() {
        user = new User();
        user.setLogin("artemTest");
        user.setLogin("artemTest");

    }

    @Test
    public void register_nullAge_notOk() {
        try {
            user.setAge(null);
            registrationService.register(user);
        } catch (InvalidUserRegistration e) {
            return;
        }
        fail("Validation failed");
    }

    @Test
    public void register_under18_notOk() {
        try {
            user.setAge(17);
            registrationService.register(user);
        } catch (InvalidUserRegistration e) {
            return;
        }
        fail("Validation failed");
    }

    @Test
    public void register_over18_Ok() {
        user.setAge(19);
        user.setPassword("artemTest");
        registrationService.register(user);
        assertEquals(19, user.getAge());
    }

    @Test
    public void register_negativeAge_notOk() {
        try {
            user.setAge(-10);
            registrationService.register(user);
        } catch (InvalidUserRegistration e) {
            return;
        }
        fail("Validation failed");
    }

    @Test
    public void register_emptyLogin_notOk() {
        try {
            user.setLogin("");
            registrationService.register(user);
        } catch (InvalidUserRegistration e) {
            return;
        }
        fail("Validation failed");
    }

    @Test
    public void register_nullLogin_notOk() {
        try {
            user.setLogin(null);
            registrationService.register(user);
        } catch (InvalidUserRegistration e) {
            return;
        }
        fail("Validation failed");
    }

    @Test
    public void register_shortLogin_notOk() {
        try {
            user.setLogin("artem");
            registrationService.register(user);
        } catch (InvalidUserRegistration e) {
            return;
        }
        fail("Validation failed");
    }

    @Test
    public void register_emptyPassword_notOk() {
        try {
            user.setPassword("");
            registrationService.register(user);
        } catch (InvalidUserRegistration e) {
            return;
        }
        fail("Validation failed");
    }

    @Test
    public void register_nullPassword_notOk() {
        try {
            user.setPassword(null);
            registrationService.register(user);
        } catch (InvalidUserRegistration e) {
            return;
        }
        fail("Validation failed");
    }

    @Test
    public void register_with5Chars_notOk() {
        try {
            user.setPassword("artem");
            registrationService.register(user);
        } catch (InvalidUserRegistration e) {
            return;
        }
        fail("Validation failed");
    }

    @Test
    public void register_user_OK() {
        user.setLogin("artemTest");
        user.setPassword("artemTest1");
        user.setAge(19);
        registrationService.register(user);
        assertEquals("artemTest", user.getLogin());
        assertEquals("artemTest1", user.getPassword());
        assertEquals(19, user.getAge());
    }

    @Test
    public void register_withoutPassword_notOK() {
        try {
            user.setLogin("artemTest");
            registrationService.register(user);
        } catch (InvalidUserRegistration e) {
            return;
        }
        fail("Validation failed");
    }

    @Test
    public void register_withoutLogin_notOK() {
        try {
            user.setPassword("artemTest");
            registrationService.register(user);
        } catch (InvalidUserRegistration e) {
            return;
        }
        fail("Validation failed");
    }

    @Test
    public void register_withoutAge_notOK() {
        try {
            user.setLogin("artemTest");
            user.setPassword("artemTest");
            registrationService.register(user);
        } catch (InvalidUserRegistration e) {
            return;
        }
        fail("Validation failed");
    }
}
