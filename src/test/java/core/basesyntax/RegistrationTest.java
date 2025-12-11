package core.basesyntax;

import static org.junit.jupiter.api.Assertions.*;

import core.basesyntax.exception.InvalidUserRegistration;
import core.basesyntax.model.User;
import core.basesyntax.service.RegistrationService;
import core.basesyntax.service.RegistrationServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Feel free to remove this class and create your own.
 */
public class RegistrationTest {
    private static RegistrationService registrationService;
    private static User user;
    @BeforeAll
    public static void testRegistration(){
        registrationService = new RegistrationServiceImpl();
        user = new User();
        user.setAge(18);
        user.setLogin("artemnurmetov");
        user.setPassword("artemnurmetov");
    }
    @Test
    public void register_nullAge_notOk(){
        try {
            user.setAge(null);
            registrationService.register(user);
        } catch (InvalidUserRegistration e) {
            return;
        }
        fail("Validation failed");
    }
    @Test
    public void register_emptyLogin_notOk(){
        try {
            user.setLogin("");
            registrationService.register(user);
        } catch (InvalidUserRegistration e) {
            return;
        }
        fail("Validation failed");
    }

    @Test
    public void register_nullLogin_notOk(){
        try {
            user.setLogin(null);
            registrationService.register(user);
        } catch (NullPointerException e) {
            return;
        }
        fail("Validation failed");
    }




}
