package pl.ultimo.qdoc.services.qdocflow.domain.log;

public interface LogAppender {
  boolean handles(LogLevel logLevel);

  void append(String message);
}
