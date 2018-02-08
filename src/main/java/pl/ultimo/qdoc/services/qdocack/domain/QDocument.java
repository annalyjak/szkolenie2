package pl.ultimo.qdoc.services.qdocack.domain;

import pl.ultimo.qdoc.services.qdocack.domain.exceptions.IllegalOperationException;
import pl.ultimo.qdoc.services.qdocack.domain.produces.QDocWasAcknowledged;
import pl.ultimo.qdoc.services.qdocack.domain.produces.QDocWasAcknowledgedByManager;
import pl.ultimo.qdoc.services.qdocack.domain.produces.QDocWasAcknowledgedByManagerWithReason;
import pl.ultimo.qdoc.services.shared.DomainEvent;
import pl.ultimo.qdoc.services.shared.EmployeeId;
import pl.ultimo.qdoc.services.shared.QDocId;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/**
 * @author Anna
 */
public class QDocument {

    private QDocId qDocId;
    private LocalDate expiractionDate;
    private Set<EmployeeId> consumers;

    //@Transient
    private List<DomainEvent> events = new ArrayList<>();

    public QDocument() {
    }

    public List<DomainEvent> getEvents() {
        return events;
    }

    public QAck ack(EmployeeId user) throws IllegalAccessException, IllegalOperationException {
        if (consumers.contains(user)) {
            throw new IllegalAccessException("Pracownik nie ma dostępu do tego dokumentu");
        }
        if (LocalDate.now().isAfter(expiractionDate)) {
            throw new IllegalOperationException("Termin zatwierdzenia upłynął!");
        }
        QAck ack = new QAck(qDocId, LocalDate.now(), user);
        events.add(new QDocWasAcknowledged(qDocId, LocalDate.now(), user));
        return ack;
    }

    public QAck ackOnBehalf(EmployeeId manager, EmployeeId user) throws IllegalOperationException {
        if (LocalDate.now().isAfter(expiractionDate)) {
            throw new IllegalOperationException("Termin zatwierdzenia upłynął, należy podać powód!");
        }
        return createAckWithoutReason(manager, user);
    }

    public QAck ackOnBehalf(EmployeeId manager, EmployeeId user, String reason) {
        if (!LocalDate.now().isAfter(expiractionDate)) {
            return createAckWithoutReason(manager, user);
        }
        QAckReason qAckReason = new QAckReason(reason);
        QAck ack = new QAck(qDocId, LocalDate.now(), user, qAckReason);
        events.add(new QDocWasAcknowledgedByManagerWithReason(qDocId, LocalDate.now(), user, manager, qAckReason));
        return ack;
    }

    private QAck createAckWithoutReason(EmployeeId manager, EmployeeId user) {
        QAck ack = new QAck(qDocId, LocalDate.now(), user);
        events.add(new QDocWasAcknowledgedByManager(qDocId, LocalDate.now(), user, manager));
        return ack;
    }
}
