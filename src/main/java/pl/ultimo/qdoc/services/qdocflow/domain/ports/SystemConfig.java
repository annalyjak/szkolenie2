package pl.ultimo.qdoc.services.qdocflow.domain.ports;

public interface SystemConfig {
  SystemType getSystemType();

  boolean isInDemoMode();
}
