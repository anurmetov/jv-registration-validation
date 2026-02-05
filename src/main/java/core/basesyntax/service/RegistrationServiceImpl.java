package core.basesyntax.service;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.exceptions.InvalidDataException;
import core.basesyntax.model.User;

public class RegistrationServiceImpl implements RegistrationService {
    private static final int MIN_LEN_PASSWORD_LOGIN = 6;
    private static final int MIN_AGE = 18;

    private final StorageDao storageDao = new StorageDaoImpl();

    @Override
    public User register(User user) throws InvalidDataException {
        if (user.getLogin() == null) {
            throw new InvalidDataException("Null login is not allowed");
        }

        if (user.getPassword() == null) {
            throw new InvalidDataException("Null password is not allowed");
        }

        if (user.getPassword().isEmpty()) {
            throw new InvalidDataException("Empty password is not allowed");

        }

        if (user.getLogin().isEmpty()) {
            throw new InvalidDataException("Empty login is not allowed");
        }

        if (storageDao.get(user.getLogin()) != null) {
            if (user.getLogin().length() >= MIN_LEN_PASSWORD_LOGIN) {

                if (user.getPassword().length() >= MIN_LEN_PASSWORD_LOGIN) {

                    if (user.getAge() >= MIN_AGE) {
                        storageDao.add(user);
                        return user;
                    } else {
                        throw new InvalidDataException("Age must be 18 or older.");
                    }

                } else {
                    throw new InvalidDataException("User password is too short! "
                            + "Min. 6 characters!");
                }

            } else {
                throw new InvalidDataException("User login is too short! Min. 6 characters!");
            }

        } else {
            throw new InvalidDataException("User exists in the storage!");
        }

    }
}
