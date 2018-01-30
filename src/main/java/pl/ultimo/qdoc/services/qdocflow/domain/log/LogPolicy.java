package pl.ultimo.qdoc.services.qdocflow.domain.log;

public interface LogPolicy {
  void log(String message, LogLevel logLevel);
}
