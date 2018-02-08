package pl.ultimo.qdoc.services.qdocack;

import pl.ultimo.qdoc.services.shared.EmployeeId;

public interface CurrentUserProvider {
    EmployeeId getUser();
}
