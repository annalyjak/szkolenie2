package pl.ultimo.qdoc.services.qdocflow.domain.validation;

public class QDocData {
  public QDocData(boolean hasOwner) {

  }

  public boolean hasNoAuthor() {
    return false;
  }

  public boolean hasNoExpirationDate() {
    return false;
  }

  public boolean hasNoNumber() {
    return false;
  }
}
