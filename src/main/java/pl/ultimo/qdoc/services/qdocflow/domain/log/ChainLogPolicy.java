package pl.ultimo.qdoc.services.qdocflow.domain.log;

import java.util.List;

public class ChainLogPolicy implements LogPolicy {


  private final List<LogAppender> appenders;

  public ChainLogPolicy(List<LogAppender> appenders) {
    this.appenders = appenders;
  }

  @Override
  public void log(String message, LogLevel logLevel) {
    for (LogAppender appender : appenders) {
      if (appender.handles(logLevel)) {
        appender.append(message);
      }
    }
  }
}
