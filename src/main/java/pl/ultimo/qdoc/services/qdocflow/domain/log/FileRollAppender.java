package pl.ultimo.qdoc.services.qdocflow.domain.log;

public class FileRollAppender implements LogAppender{
  public FileRollAppender(LogLevel info) {
  }

  @Override
  public boolean handles(LogLevel logLevel) {
    return false;
  }

  @Override
  public void append(String message) {

  }
}
