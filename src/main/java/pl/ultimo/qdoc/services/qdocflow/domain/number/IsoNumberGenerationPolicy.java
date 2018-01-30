package pl.ultimo.qdoc.services.qdocflow.domain.number;

import java.time.LocalDate;

public class IsoNumberGenerationPolicy implements NumberGenerationPolicy {
  @Override
  public QDocNumber generate() {
    return new QDocNumber("ISO").addSuffix(LocalDate.now().toString());
  }
}
