package pl.ultimo.qdoc.services.qdocack;

import pl.ultimo.qdoc.services.qdocack.domain.QAck;
import pl.ultimo.qdoc.services.qdocack.domain.QAckEmployee;
import pl.ultimo.qdoc.services.qdocack.domain.QDocument;
import pl.ultimo.qdoc.services.qdocack.domain.exceptions.IllegalOperationException;
import pl.ultimo.qdoc.services.shared.EmployeeId;
import pl.ultimo.qdoc.services.shared.QDocId;

import java.util.function.Consumer;
import java.util.function.Function;

public interface QDocumentRepo {

    QDocument load(QDocId qDocId);

    QAckEmployee load(EmployeeId employeeId);

    void save(QAck ack);

    default void accept(QDocId qDocId, Function<QDocument, QAck> function) {
        final QDocument qDocument = load(qDocId);
        QAck qAck = function.apply(qDocument);
        save(qAck);
    }

}
