package pl.ultimo.qdoc.services.qdocflow.domain;

import pl.ultimo.qdoc.services.qdocflow.domain.number.QDocNumber;
import pl.ultimo.qdoc.services.shared.QDocId;
import pl.ultimo.qdoc.services.shared.QmId;

public class QDocument {
  private final QDocId qDocId;
  private final QDocNumber qDocNumber;
  private final QDocType qDocType;
  private final QmId ownerId;

  public QDocument(QDocId qDocId, QDocNumber qDocNumber, QDocType qDocType, QmId ownerId) {
    this.qDocId = qDocId;
    this.qDocNumber = qDocNumber;
    this.qDocType = qDocType;
    this.ownerId = ownerId;
  }
}
