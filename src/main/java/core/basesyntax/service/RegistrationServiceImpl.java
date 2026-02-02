package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.exceptions.InvalidDataException;
import core.basesyntax.model.User;

public class RegistrationServiceImpl implements RegistrationService {
    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public User register(User user) throws InvalidDataException {
        if (!Storage.people.contains(storageDao.get(user.getLogin()))) {
            if (user.getLogin().length() >= 6) {

                if (user.getPassword().length() >= 6) {
                    storageDao.add(user);
                    return user;
                } else {
                    throw new InvalidDataException("User password is too short! Min. 6 characters!");

                }
            } else {
                throw new InvalidDataException("User login is too short! Min. 6 characters!");
            }
        } else {
            throw new InvalidDataException("User exists in the storage!");
        }

    }
}
