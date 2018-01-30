package pl.ultimo.qdoc.services.qdocflow.domain;

import pl.ultimo.qdoc.services.shared.QDocId;

public class QDocFlowService {


  private final QDocumentRepo repo;
  private final QDocFactory qDocFactory;

  public QDocFlowService(QDocumentRepo repo, QDocFactory qDocFactory) {
    this.repo = repo;
    this.qDocFactory = qDocFactory;
  }

  public void create(QDocType qDocType, QDocId qDocId) {
    repo.save(qDocFactory.qdocFactory(qDocType, qDocId));
  }

  void toVerify() {

  }

  void verify() {

  }

  void publish() {

  }

  void archive() {

  }
}
