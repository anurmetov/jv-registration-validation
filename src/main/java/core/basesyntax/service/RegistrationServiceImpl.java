package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.exception.InvalidUserRegistration;
import core.basesyntax.model.User;

public class RegistrationServiceImpl implements RegistrationService {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public User register(User user) {
        if (user.getLogin() == null) {
            throw new InvalidUserRegistration("Login cannot be null");
        }
        if (user.getPassword() == null) {
            throw new InvalidUserRegistration("Password cannot be null");
        }
        if (user.getAge() == null) {
            throw new InvalidUserRegistration("Age cannot be null");
        }
        if (user.getLogin().length() < 6) {
            throw new InvalidUserRegistration("Login length cannot be less than 6");
        }
        if (user.getPassword().length() < 6) {
            throw new InvalidUserRegistration("Password length cannot be less than 6");
        }
        if (user.getAge() <= 18) {
            throw new InvalidUserRegistration("Age cannot be less than 18");
        }
        if (Storage.people.contains(user)) {
            throw new InvalidUserRegistration("This user already exists");
        }
        storageDao.add(user);
        return user;
    }
}
