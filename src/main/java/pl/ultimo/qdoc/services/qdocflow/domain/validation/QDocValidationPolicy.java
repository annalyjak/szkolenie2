package pl.ultimo.qdoc.services.qdocflow.domain.validation;

import pl.ultimo.qdoc.services.qdocflow.domain.QDocStatus;

public interface QDocValidationPolicy {
  void validate(QDocStatus verified, QDocData qDocData);
}
