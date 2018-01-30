package pl.ultimo.qdoc.services.qdocflow.domain.log;

public class FileAppender implements LogAppender{
  public FileAppender(LogLevel info) {
  }

  @Override
  public boolean handles(LogLevel logLevel) {
    return false;
  }

  @Override
  public void append(String message) {

  }
}
