package pl.ultimo.qdoc.services.qdocflow.domain.ports;

import pl.ultimo.qdoc.services.shared.QmId;

public interface FlowUserProvider {
  boolean isAuditor();

  QmId getId();
}
