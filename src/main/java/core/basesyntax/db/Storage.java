package core.basesyntax.db;

import core.basesyntax.model.User;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static final List<User> people = new ArrayList<>();

    @Override
    public String toString() {
        return "Storage: " + people.toString();
    }
}
