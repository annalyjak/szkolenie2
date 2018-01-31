package pl.ultimo.qdoc.services.qdocflow.domain.validation;

import java.util.List;

public class ValidationExc extends RuntimeException {
  public ValidationExc(List<CheckingResult> errorRasults) {
  }
}
