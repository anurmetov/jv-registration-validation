package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.InvalidDataException;
import core.basesyntax.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationServiceImplTest {
    private static RegistrationService registrationService;
    private static StorageDao storageDao;

    @BeforeAll
    static void beforeAll() {
        registrationService = new RegistrationServiceImpl();
        storageDao = new StorageDaoImpl();
    }

    @BeforeEach
    void setUp() {
        User firstUser = new User();
        firstUser.setLogin("firstLogin");
        firstUser.setPassword("firstPassword");
        firstUser.setId(1L);
        firstUser.setAge(18);
        User secondUser = new User();
        secondUser.setLogin("secondLogin");
        secondUser.setPassword("secondPassword");
        secondUser.setId(1L);
        secondUser.setAge(18);
        storageDao.add(firstUser);
        storageDao.add(secondUser);
    }



    @Test
    void register_noSameLoginStorage_Ok() throws InvalidDataException {
        User newUser = new User();
        newUser.setLogin("uniqueLogin");
        newUser.setPassword("uniquePassword");
        newUser.setId(3L);
        newUser.setAge(20);
        User registeredUser = registrationService.register(newUser);
        assertEquals(newUser, registeredUser);
        User fromStorage = storageDao.get("uniqueLogin");
        assertEquals(newUser, fromStorage);
    }


    @Test
    void register_loginSixChars_Ok() throws InvalidDataException {
        User newUser = new User();
        newUser.setLogin("unique");
        newUser.setPassword("uniquePassword");
        newUser.setId(3L);
        newUser.setAge(20);
        User registeredUser = registrationService.register(newUser);
        assertEquals(newUser.getLogin().length(), registeredUser.getLogin().length());
    }

    @Test
    void register_passwordSixChars_Ok() throws InvalidDataException {

        // FDASFDA
        User newUser = new User();
        newUser.setLogin("unique");
        newUser.setPassword("unique");
        newUser.setId(3L);
        newUser.setAge(20);
        User registeredUser = registrationService.register(newUser);
        assertEquals(6, registeredUser.getPassword().length());
    }

    @Test
    void register_userAgeEighteen_Ok() {

    }


}