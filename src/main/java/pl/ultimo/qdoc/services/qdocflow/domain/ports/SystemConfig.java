package pl.ultimo.qdoc.services.qdocflow.domain.ports;

import pl.ultimo.qdoc.services.qdocflow.domain.log.LogProfile;

public interface SystemConfig {
  SystemType getSystemType();

  boolean isInDemoMode();

  LogProfile getProfile();

}
