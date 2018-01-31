package pl.ultimo.qdoc.services.qdocflow.domain.validation;

import pl.ultimo.qdoc.services.qdocflow.domain.QDocStatus;

public class ExpirationDateChecker extends CheckerTemplate {

  public ExpirationDateChecker(QDocStatus qDocStatus) {
    super(qDocStatus);
  }

  @Override
  protected String message() {
    return "has no expiration date";
  }

  @Override
  protected boolean condition(QDocData qDocData) {
    return qDocData.hasNoExpirationDate();
  }
}
