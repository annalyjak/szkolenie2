package pl.ultimo.qdoc.services.qdocflow.domain.number;

import java.time.LocalDate;

public class QepNumberGenerationPolicy implements NumberGenerationPolicy {
  @Override
  public QDocNumber generate() {
    return new QDocNumber("QEP").addSuffix(LocalDate.now().toString());
  }
}
