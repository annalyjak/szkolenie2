package pl.ultimo.qdoc.services.qdocflow.domain.validation;

import pl.ultimo.qdoc.services.qdocflow.domain.QDocStatus;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ChainQDocValidationPolicy implements QDocValidationPolicy {

  private final List<QDocChecker> qDocCheckers;

  public ChainQDocValidationPolicy(List<QDocChecker> qDocCheckers) {
    this.qDocCheckers = qDocCheckers;
  }

  @Override
  public void validate(QDocStatus desiredState, QDocData qDocData) {

    List<CheckingResult> results = new LinkedList<>();
    for (QDocChecker qDocChecker : qDocCheckers) {
      if(qDocChecker.handles(desiredState)) {
        CheckingResult result = qDocChecker.check(qDocData);
        results.add(result);
      }
    }

    final List<CheckingResult> errorResults = results.stream().filter(Objects::nonNull).collect(Collectors.toList());
    if (!errorResults.isEmpty()) {
      throw new ValidationExc(errorResults);
    }
  }
}
