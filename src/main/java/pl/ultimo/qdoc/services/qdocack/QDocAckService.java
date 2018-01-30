package pl.ultimo.qdoc.services.qdocack;

import pl.ultimo.qdoc.services.shared.EmployeeId;
import pl.ultimo.qdoc.services.shared.QDocId;

public class QDocAckService {


  private final CurrentUserProvider userProvider;

  public QDocAckService(CurrentUserProvider userProvider) {
    this.userProvider = userProvider;
  }

  void ack(QDocId qDocId) {
//      userProvider
  }

  void ackOnBehalf(QDocId qDocId, EmployeeId employeeId) {

  }

}
