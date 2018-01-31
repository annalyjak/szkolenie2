package pl.ultimo.qdoc.services.qdocflow.domain.validation;

import pl.ultimo.qdoc.services.qdocflow.domain.QDocStatus;

public class AuthorChecker extends CheckerTemplate {

  public AuthorChecker(QDocStatus qDocStatus) {
    super(qDocStatus);
  }

  @Override
  protected String message() {
    return "validation message";
  }

  @Override
  protected boolean condition(QDocData qDocData) {
    return qDocData.hasNoAuthor();
  }

}
