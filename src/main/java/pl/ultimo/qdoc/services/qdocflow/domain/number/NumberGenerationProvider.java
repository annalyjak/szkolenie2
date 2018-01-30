package pl.ultimo.qdoc.services.qdocflow.domain.number;

import pl.ultimo.qdoc.services.qdocflow.domain.ports.FlowUserProvider;
import pl.ultimo.qdoc.services.qdocflow.domain.ports.SystemConfig;
import pl.ultimo.qdoc.services.qdocflow.domain.ports.SystemType;

import java.util.HashMap;
import java.util.Map;

import static pl.ultimo.qdoc.services.qdocflow.domain.ports.SystemType.ISO;
import static pl.ultimo.qdoc.services.qdocflow.domain.ports.SystemType.QEP;

public class NumberGenerationProvider {


  private final SystemConfig systemConfig;
  private final FlowUserProvider userProvider;


  private Map<SystemType, NumberGenerationPolicy> maps = new HashMap<>();
  {
    maps.put(ISO, new IsoNumberGenerationPolicy());
    maps.put(QEP, new QepNumberGenerationPolicy());
  }


  public NumberGenerationProvider(SystemConfig systemConfig, FlowUserProvider userProvider) {
    this.systemConfig = systemConfig;
    this.userProvider = userProvider;
  }

  public NumberGenerationPolicy get() {

    NumberGenerationPolicy policy = maps.get(systemConfig.getSystemType());

    if (systemConfig.isInDemoMode()) {
      policy = new NumberGenerationPolicyDemoDecorator(policy);
    }
    if (userProvider.isAuditor()) {
      policy = new NumberGenerationPolicyAuditorDecorator(policy);
    }

    return policy;
  }
}
