package pl.ultimo.qdoc.services.qdocflow.domain.validation;

import pl.ultimo.qdoc.services.qdocflow.domain.QDocStatus;

public class NumberChecker extends CheckerTemplate {

  public NumberChecker(QDocStatus qDocStatus) {
    super(qDocStatus);
  }

  @Override
  protected String message() {
    return "has no number";
  }

  @Override
  protected boolean condition(QDocData qDocData) {
    return qDocData.hasNoNumber();
  }
}
