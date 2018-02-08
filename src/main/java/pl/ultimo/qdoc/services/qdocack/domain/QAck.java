package pl.ultimo.qdoc.services.qdocack.domain;

import pl.ultimo.qdoc.services.shared.EmployeeId;
import pl.ultimo.qdoc.services.shared.QDocId;

import java.time.LocalDate;
import java.util.UUID;
/**
 * @author Anna
 */
public class QAck {

    private QAckId ackId;
    private QDocId qDocId;
    private LocalDate ackDate;
    private EmployeeId employee;
    private QAckReason reason;

    public QAck(QDocId qDocId, LocalDate ackDate, EmployeeId employee) {
        this.ackId = new QAckId(UUID.randomUUID());
        this.qDocId = qDocId;
        this.ackDate = ackDate;
        this.employee = employee;
    }

    public QAck(QDocId qDocId, LocalDate ackDate, EmployeeId employee, QAckReason reason) {
        this.ackId = new QAckId(UUID.randomUUID());
        this.qDocId = qDocId;
        this.ackDate = ackDate;
        this.employee = employee;
        this.reason = reason;
    }

}