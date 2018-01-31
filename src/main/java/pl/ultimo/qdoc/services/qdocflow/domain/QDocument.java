package pl.ultimo.qdoc.services.qdocflow.domain;

import pl.ultimo.qdoc.services.qdocflow.domain.number.QDocNumber;
import pl.ultimo.qdoc.services.qdocflow.domain.produces.QDocWasArchived;
import pl.ultimo.qdoc.services.qdocflow.domain.produces.QDocWasCreated;
import pl.ultimo.qdoc.services.qdocflow.domain.produces.QDocWasPublished;
import pl.ultimo.qdoc.services.qdocflow.domain.produces.QDocWasVerified;
import pl.ultimo.qdoc.services.qdocflow.domain.validation.QDocData;
import pl.ultimo.qdoc.services.qdocflow.domain.validation.QDocValidationPolicy;
import pl.ultimo.qdoc.services.shared.DomainEvent;
import pl.ultimo.qdoc.services.shared.QDocId;
import pl.ultimo.qdoc.services.shared.QmId;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class QDocument {

  private QDocId qDocId;
  private QDocNumber qDocNumber;
  private QDocType qDocType;
  private QmId ownerId;
  private QDocStatus qDocStatus;

  //@Transient
  private List<DomainEvent> events = new ArrayList<>();

  public QDocument() {
  }

  public List<DomainEvent> getEvents() {
    return events;
  }

  public QDocument(QDocId qDocId, QDocNumber qDocNumber, QDocType qDocType, QmId ownerId) {
    this.qDocId = qDocId;
    this.qDocNumber = qDocNumber;
    this.qDocType = qDocType;
    this.ownerId = ownerId;
    this.qDocStatus = QDocStatus.DRAFT;

    events.add(new QDocWasCreated(qDocId, LocalDateTime.now(), qDocNumber.toString(), ownerId, qDocType.toString()));
  }

  public void verify(QDocValidationPolicy qdocValidationPolicy) {
    qdocValidationPolicy.validate(QDocStatus.VERIFIED, getQDocData());
    this.qDocStatus = QDocStatus.VERIFIED;
    events.add(new QDocWasVerified());
  }

  private QDocData getQDocData() {
    return new QDocData(ownerId != null);
  }

  public void publish(QDocValidationPolicy qdocValidationPolicy) {
    qdocValidationPolicy.validate(QDocStatus.PUBLISHED, getQDocData());
    this.qDocStatus = QDocStatus.PUBLISHED;
    events.add(new QDocWasPublished());
  }

  public void archive(QDocValidationPolicy qDocValidationPolicy) {

    events.add(new QDocWasArchived());
  }
}
