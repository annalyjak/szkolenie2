package pl.ultimo.qdoc.services.qdocflow.domain.log;

public class ConsoleAppender implements LogAppender {

  private final LogLevel myLogLevel;

  public ConsoleAppender(LogLevel myLogLevel) {
    this.myLogLevel = myLogLevel;
  }

  @Override
  public boolean handles(LogLevel logLevel) {
    return myLogLevel.equals(logLevel);
  }

  @Override
  public void append(String message) {
    System.out.println(message);
  }
}
