package pl.ultimo.qdoc.services.qdocflow.domain.validation;

import pl.ultimo.qdoc.services.qdocflow.domain.QDocStatus;

public abstract class CheckerTemplate implements QDocChecker{
  protected final QDocStatus qDocStatus;

  public CheckerTemplate(QDocStatus qDocStatus) {
    this.qDocStatus = qDocStatus;
  }

  public CheckingResult check(QDocData qDocData) {
    if (condition(qDocData)) {
      return new CheckingResult(message());
    } else {
      return null;
    }
  }

  protected abstract String message();

  protected abstract boolean condition(QDocData qDocData);

  public boolean handles(QDocStatus desiredState) {
    return qDocStatus.equals(desiredState);
  }
}
