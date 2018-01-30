package pl.ultimo.qdoc.services.qdocflow.domain;

import pl.ultimo.qdoc.services.qdocflow.domain.number.NumberGenerationProvider;
import pl.ultimo.qdoc.services.qdocflow.domain.number.QDocNumber;
import pl.ultimo.qdoc.services.qdocflow.domain.ports.FlowUserProvider;
import pl.ultimo.qdoc.services.shared.QDocId;
import pl.ultimo.qdoc.services.shared.QmId;

public class QDocFactory {
  final private NumberGenerationProvider numberGenerationProvider;
  private final FlowUserProvider userProvider;

  public QDocFactory(NumberGenerationProvider numberGenerationProvider, FlowUserProvider userProvider) {
    this.numberGenerationProvider = numberGenerationProvider;
    this.userProvider = userProvider;
  }


  QDocument qdocFactory(QDocType qDocType, QDocId qDocId) {
   QDocNumber qDocNumber = numberGenerationProvider.get().generate();
   final QmId id = userProvider.getId();
   return new QDocument(qDocId, qDocNumber, qDocType, id);
 }
}
