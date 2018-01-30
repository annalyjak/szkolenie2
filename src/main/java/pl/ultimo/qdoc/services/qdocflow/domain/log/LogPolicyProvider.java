package pl.ultimo.qdoc.services.qdocflow.domain.log;

import pl.ultimo.qdoc.services.qdocflow.domain.ports.SystemConfig;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static pl.ultimo.qdoc.services.qdocflow.domain.log.LogLevel.DEBUG;
import static pl.ultimo.qdoc.services.qdocflow.domain.log.LogLevel.INFO;
import static pl.ultimo.qdoc.services.qdocflow.domain.log.LogLevel.WARN;

public class LogPolicyProvider {


  Map<LogProfile, List<LogAppender>> map = new HashMap<>();
  {
    map.put(LogProfile.DEV, Arrays.asList(new ConsoleAppender(INFO),new ConsoleAppender(WARN), new ConsoleAppender(DEBUG)));
    map.put(LogProfile.PROD, Arrays.asList(new FileAppender(INFO),new ConsoleAppender(WARN), new NullAppender(DEBUG)));
    map.put(LogProfile.TEST, Arrays.asList(new FileRollAppender(INFO),new FileRollAppender(WARN), new NullAppender(DEBUG)));
  }

  private final SystemConfig systemConfig;

  public LogPolicyProvider(SystemConfig systemConfig) {
    this.systemConfig = systemConfig;
  }


  LogPolicy get() {
    List<LogAppender> chain = map.get(systemConfig.getProfile());
    return new ChainLogPolicy(chain);
  }
}
