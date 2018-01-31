package pl.ultimo.qdoc.services.qdocflow.domain;

import pl.ultimo.qdoc.services.shared.QDocId;

public interface QDocumentRepo {
  void save(QDocument qDocument);

  QDocument load(QDocId qDocId);
}
