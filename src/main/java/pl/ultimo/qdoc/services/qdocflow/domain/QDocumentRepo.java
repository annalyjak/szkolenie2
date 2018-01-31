package pl.ultimo.qdoc.services.qdocflow.domain;

import pl.ultimo.qdoc.services.shared.QDocId;

import java.util.function.Consumer;

public interface QDocumentRepo {
  void save(QDocument qDocument);

  QDocument load(QDocId qDocId);

  default void accept(QDocId qDocId, Consumer<QDocument> consumer) {
    final QDocument qDocument = load(qDocId);
    consumer.accept(qDocument);
    save(qDocument);
  }
}
