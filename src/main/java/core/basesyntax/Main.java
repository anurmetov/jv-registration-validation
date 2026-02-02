package core.basesyntax;

import core.basesyntax.exceptions.InvalidDataException;
import core.basesyntax.model.User;
import core.basesyntax.service.RegistrationService;
import core.basesyntax.service.RegistrationServiceImpl;

public class Main {
    public static void main(String[] args) throws InvalidDataException {
        RegistrationService registrationService = new RegistrationServiceImpl();
        User newUser = new User();
        newUser.setLogin("uniq");
        newUser.setPassword("uniquePassword");
        newUser.setId(3L);
        newUser.setAge(20);

        registrationService.register(newUser);
    }

}
