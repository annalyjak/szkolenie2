package pl.ultimo.qdoc.services.qdocack.domain.produces;

import pl.ultimo.qdoc.services.shared.DomainEvent;
import pl.ultimo.qdoc.services.shared.EmployeeId;
import pl.ultimo.qdoc.services.shared.QDocId;

import java.time.LocalDate;
/**
 * @author Anna
 */
public class QDocWasAcknowledgedByManager implements DomainEvent {
    public QDocWasAcknowledgedByManager(QDocId qDocId, LocalDate now, EmployeeId user, EmployeeId manager) {

    }
}
