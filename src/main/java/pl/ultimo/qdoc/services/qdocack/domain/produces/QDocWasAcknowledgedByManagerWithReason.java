package pl.ultimo.qdoc.services.qdocack.domain.produces;

import pl.ultimo.qdoc.services.qdocack.domain.QAckReason;
import pl.ultimo.qdoc.services.shared.DomainEvent;
import pl.ultimo.qdoc.services.shared.EmployeeId;
import pl.ultimo.qdoc.services.shared.QDocId;

import java.time.LocalDate;
/**
 * @author Anna
 */
public class QDocWasAcknowledgedByManagerWithReason implements DomainEvent {
    public QDocWasAcknowledgedByManagerWithReason(QDocId qDocId, LocalDate now, EmployeeId user, EmployeeId manager, QAckReason qAckReason) {
    }
}
