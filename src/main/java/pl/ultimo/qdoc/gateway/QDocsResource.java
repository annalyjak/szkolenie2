package pl.ultimo.qdoc.gateway;

import pl.ultimo.qdoc.services.qdocflow.domain.QDocFlowService;
import pl.ultimo.qdoc.services.qdocflow.domain.QDocType;
import pl.ultimo.qdoc.services.shared.QDocId;

public class QDocsResource {


  private final QDocFlowService qDocFlowService;

  public QDocsResource(QDocFlowService qDocFlowService) {
    this.qDocFlowService = qDocFlowService;
  }

  String create(String qdocType) {
    final QDocId qDocId = new QDocId();
    qDocFlowService.create(QDocType.valueOf(qdocType), qDocId);
    return qDocId.toString();
  }

}
