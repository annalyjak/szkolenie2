package pl.ultimo.qdoc.services.qdocflow.domain;

import pl.ultimo.qdoc.services.qdocflow.domain.number.QDocNumber;
import pl.ultimo.qdoc.services.qdocflow.domain.validation.QDocData;
import pl.ultimo.qdoc.services.qdocflow.domain.validation.QDocValidationPolicy;
import pl.ultimo.qdoc.services.shared.QDocId;
import pl.ultimo.qdoc.services.shared.QmId;

public class QDocument {
  private final QDocId qDocId;
  private final QDocNumber qDocNumber;
  private final QDocType qDocType;
  private final QmId ownerId;
  private QDocStatus qDocStatus;

  public QDocument(QDocId qDocId, QDocNumber qDocNumber, QDocType qDocType, QmId ownerId) {
    this.qDocId = qDocId;
    this.qDocNumber = qDocNumber;
    this.qDocType = qDocType;
    this.ownerId = ownerId;
    this.qDocStatus = QDocStatus.DRAFT;
  }

  public void verify(QDocValidationPolicy qdocValidationPolicy) {
    qdocValidationPolicy.validate(QDocStatus.VERIFIED, getQDocData());
    this.qDocStatus = QDocStatus.VERIFIED;
  }

  private QDocData getQDocData() {
    return new QDocData(ownerId!=null);
  }

  public void publish(QDocValidationPolicy qdocValidationPolicy) {
    qdocValidationPolicy.validate(QDocStatus.PUBLISHED, getQDocData());
    this.qDocStatus = QDocStatus.PUBLISHED;
  }
}
