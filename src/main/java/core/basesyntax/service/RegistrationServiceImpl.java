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
        if (!Storage.people.contains(user) && user.getLogin().length() >= 6
        && user.getPassword().length() >= 6 && user.getAge() >= 18) {
            storageDao.add(user);
            return user;
        } else {
            throw new InvalidUserRegistration("This user already exists or login/password are too short or user is under 18");
        }
    }
}
