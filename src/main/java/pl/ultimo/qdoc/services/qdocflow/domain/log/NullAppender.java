package pl.ultimo.qdoc.services.qdocflow.domain.log;

public class NullAppender implements LogAppender {
  public NullAppender(LogLevel debug) {
  }

  @Override
  public boolean handles(LogLevel logLevel) {
    return false;
  }

  @Override
  public void append(String message) {

  }
}
