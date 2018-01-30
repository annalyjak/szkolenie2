package pl.ultimo.qdoc.services.qdocflow.domain.number;

public class NumberGenerationPolicyAuditorDecorator implements NumberGenerationPolicy {

  private final NumberGenerationPolicy policy;

  public NumberGenerationPolicyAuditorDecorator(NumberGenerationPolicy policy) {
    this.policy = policy;
  }

  @Override
  public QDocNumber generate() {
    return policy.generate().addSuffix("AUDIT");
  }
}
