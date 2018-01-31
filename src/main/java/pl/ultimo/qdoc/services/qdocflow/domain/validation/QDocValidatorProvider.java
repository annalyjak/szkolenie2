package pl.ultimo.qdoc.services.qdocflow.domain.validation;

import pl.ultimo.qdoc.services.qdocflow.domain.QDocStatus;
import pl.ultimo.qdoc.services.qdocflow.domain.ports.SystemConfig;
import pl.ultimo.qdoc.services.qdocflow.domain.ports.SystemType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QDocValidatorProvider {


  private final SystemConfig systemConfig;

  public QDocValidatorProvider(SystemConfig  systemConfig) {
    this.systemConfig = systemConfig;
  }

  Map<SystemType, List<QDocChecker>> map = new HashMap<>();
  {
    map.put(SystemType.ISO, Arrays.asList(new NumberChecker(QDocStatus.VERIFIED), new ExpirationDateChecker(QDocStatus.PUBLISHED)));
    map.put(SystemType.QEP, Arrays.asList(new NumberChecker(QDocStatus.PUBLISHED), new AuthorChecker(QDocStatus.VERIFIED)));
  }

  public QDocValidationPolicy get() {
    return new ChainQDocValidationPolicy(map.get(systemConfig.getSystemType()));
  }
}
