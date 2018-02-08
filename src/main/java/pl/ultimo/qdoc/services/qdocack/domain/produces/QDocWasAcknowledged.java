package pl.ultimo.qdoc.services.qdocack.domain.produces;

import pl.ultimo.qdoc.services.shared.DomainEvent;
import pl.ultimo.qdoc.services.shared.EmployeeId;
import pl.ultimo.qdoc.services.shared.QDocId;

import java.time.LocalDate;

/**
 * @author Anna
 */
public class QDocWasAcknowledged implements DomainEvent {
    public QDocWasAcknowledged(QDocId qDocId, LocalDate now, EmployeeId user) {
    }
}
