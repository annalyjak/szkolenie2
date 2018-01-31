package pl.ultimo.qdoc.services.qdocflow.domain.validation;

import pl.ultimo.qdoc.services.qdocflow.domain.QDocStatus;

public interface QDocChecker {
  CheckingResult check(QDocData qDocData);

  boolean handles(QDocStatus desiredState);
}
