package pl.ultimo.qdoc.services.qdocflow.domain;

import pl.ultimo.qdoc.services.qdocflow.domain.log.LogLevel;
import pl.ultimo.qdoc.services.qdocflow.domain.log.LogPolicyProvider;
import pl.ultimo.qdoc.services.shared.QDocId;

public class QDocFlowService {


  private final QDocumentRepo repo;
  private final QDocFactory qDocFactory;
  private final LogPolicyProvider logPolicyProvider;

  public QDocFlowService(QDocumentRepo repo, QDocFactory qDocFactory, LogPolicyProvider logPolicyProvider) {
    this.repo = repo;
    this.qDocFactory = qDocFactory;
    this.logPolicyProvider = logPolicyProvider;
  }

  public void create(QDocType qDocType, QDocId qDocId) {
    repo.save(qDocFactory.qdocFactory(qDocType, qDocId));
  }

  void toVerify() {
    logPolicyProvider.get().log("starting verification", LogLevel.INFO);
  }

  void verify() {

  }

  void publish() {

  }

  void archive() {

  }
}
