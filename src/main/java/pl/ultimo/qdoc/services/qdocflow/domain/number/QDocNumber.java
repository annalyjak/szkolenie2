package pl.ultimo.qdoc.services.qdocflow.domain.number;

public class QDocNumber {
  private static final String SEPARATOR = "/";
  private final String type;

  public QDocNumber(String type) {
    this.type = type;
  }

  public QDocNumber addSuffix(String suffix) {
    return new QDocNumber(type + "/" + suffix);
  }

  public QDocNumber addPrefix(String prefix) {
    return new QDocNumber(prefix + SEPARATOR + type);
  }
}
