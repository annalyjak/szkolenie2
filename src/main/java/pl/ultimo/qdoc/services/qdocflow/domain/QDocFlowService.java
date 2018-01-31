package pl.ultimo.qdoc.services.qdocflow.domain;

import pl.ultimo.qdoc.services.qdocflow.domain.log.LogLevel;
import pl.ultimo.qdoc.services.qdocflow.domain.log.LogPolicyProvider;
import pl.ultimo.qdoc.services.qdocflow.domain.validation.QDocValidationPolicy;
import pl.ultimo.qdoc.services.qdocflow.domain.validation.QDocValidatorProvider;
import pl.ultimo.qdoc.services.shared.QDocId;

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

    QDocument qDocument = repo.load(qDocId);
    QDocValidationPolicy qdocValidationPolicy = qDocValidatorProvider.get();

    qDocument.verify(qdocValidationPolicy);

    repo.save(qDocument);

  }

  void publish(QDocId qDocId) {
    QDocument qDocument = repo.load(qDocId);
    QDocValidationPolicy qdocValidationPolicy = qDocValidatorProvider.get();

    qDocument.publish(qdocValidationPolicy);

    repo.save(qDocument);
  }

  void archive() {

  }
}
