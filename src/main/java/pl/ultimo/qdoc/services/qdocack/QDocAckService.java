package pl.ultimo.qdoc.services.qdocack;

import pl.ultimo.qdoc.services.qdocack.domain.QAckEmployee;
import pl.ultimo.qdoc.services.qdocack.domain.QDocument;
import pl.ultimo.qdoc.services.qdocack.domain.exceptions.IllegalOperationException;
import pl.ultimo.qdoc.services.shared.EmployeeId;
import pl.ultimo.qdoc.services.shared.QDocId;

public class QDocAckService {

  private final CurrentUserProvider userProvider;
  private final QDocumentRepo repo;

  public QDocAckService(CurrentUserProvider userProvider, QDocumentRepo repo) {
    this.userProvider = userProvider;
    this.repo = repo;
  }

  void ack(QDocId qDocId) throws IllegalAccessException, IllegalOperationException {
      QDocument document = repo.load(qDocId);
      repo.save(document.ack(userProvider.getUser()));
  }

  void ackOnBehalf(QDocId qDocId, EmployeeId employeeId) throws IllegalOperationException {
        QAckEmployee employee = repo.load(employeeId);
        if (!employee.isEmployeeManager(userProvider.getUser())) {
            throw new IllegalOperationException("Użytkownik nie jest managerem liniowym tego pracownika!");
        }
        QDocument document = repo.load(qDocId);
        repo.save(document.ackOnBehalf(employeeId, userProvider.getUser()));
  }

    void ackOnBehalf(QDocId qDocId, EmployeeId employeeId, String reason) throws IllegalOperationException {
        QAckEmployee employee = repo.load(employeeId);
        if (!employee.isEmployeeManager(userProvider.getUser())) {
            throw new IllegalOperationException("Użytkownik nie jest managerem liniowym tego pracownika!");
        }
        repo.accept(qDocId, qDocument -> qDocument.ackOnBehalf(employeeId, userProvider.getUser(), reason));
    }

}
