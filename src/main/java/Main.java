import core.basesyntax.db.Storage;
import core.basesyntax.model.User;
import core.basesyntax.service.RegistrationService;
import core.basesyntax.service.RegistrationServiceImpl;

public class Main {
    public static void main(String[] args) {
        RegistrationService registrationService = new RegistrationServiceImpl();
        Storage storage = new Storage();
        User user = new User();
        user.setAge(18);
        user.setLogin(null);
        user.setPassword("artemnurmetov");
        registrationService.register(user);

    }
}
