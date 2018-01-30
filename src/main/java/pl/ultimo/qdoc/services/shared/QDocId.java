package pl.ultimo.qdoc.services.shared;

import java.util.UUID;

public class QDocId {

  private final UUID value;

  public QDocId() {
    this.value = UUID.randomUUID();
  }

  public QDocId(UUID value) {
    this.value = value;
  }
}
