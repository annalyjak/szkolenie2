package pl.ultimo.qdoc.services.qdocflow.domain;

import pl.ultimo.qdoc.services.qdocflow.domain.log.LogLevel;
import pl.ultimo.qdoc.services.qdocflow.domain.log.LogPolicyProvider;
import pl.ultimo.qdoc.services.qdocflow.domain.validation.QDocValidatorProvider;
import pl.ultimo.qdoc.services.shared.QDocId;

import java.util.List;
import java.util.function.Consumer;

public class QDocFlowService {


  private final QDocumentRepo repo;
  private final QDocFactory qDocFactory;
  private final LogPolicyProvider logPolicyProvider;
  private final QDocValidatorProvider qDocValidatorProvider;

  public QDocFlowService(QDocumentRepo repo, QDocFactory qDocFactory, LogPolicyProvider logPolicyProvider, QDocValidatorProvider qDocValidatorProvider) {
    this.repo = repo;
    this.qDocFactory = qDocFactory;
    this.logPolicyProvider = logPolicyProvider;
    this.qDocValidatorProvider = qDocValidatorProvider;
  }

  public void create(QDocType qDocType, QDocId qDocId) {
    repo.save(qDocFactory.qdocFactory(qDocType, qDocId));
  }

  void toVerify() {
    logPolicyProvider.get().log("starting verification", LogLevel.INFO);
  }

  void verify(QDocId qDocId) {
    repo.accept(qDocId, qDocument -> qDocument.verify(qDocValidatorProvider.get()));
  }

  void publish(QDocId qDocId) {
    repo.accept(qDocId, qDocument -> qDocument.publish(qDocValidatorProvider.get()));
  }

  void archive(QDocId qDocId) {
    repo.accept(qDocId, qDocument -> qDocument.archive(qDocValidatorProvider.get()));
  }


  void bulcPublish(List<QDocId> docs) {
    // Ag ag = load(docs);
    // ag.bulkPublish()
    // save(ag);


  }

}
