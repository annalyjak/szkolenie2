package pl.ultimo.qdoc.services.qdocflow.domain;

import pl.ultimo.qdoc.services.shared.QDocId;

import java.util.function.Consumer;

public interface QDocumentRepo {
  // @Transactional
  default void save(QDocument qDocument) {
    // dao.save(qDocument)
    // eventPublisher.publish(qDocument.getEvents())
  }

  QDocument load(QDocId qDocId);

  default void accept(QDocId qDocId, Consumer<QDocument> consumer) {
    final QDocument qDocument = load(qDocId);
    consumer.accept(qDocument);
    save(qDocument);
  }
}
