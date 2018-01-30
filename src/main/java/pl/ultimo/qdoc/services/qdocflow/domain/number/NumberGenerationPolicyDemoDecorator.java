package pl.ultimo.qdoc.services.qdocflow.domain.number;

public class NumberGenerationPolicyDemoDecorator implements NumberGenerationPolicy {

  private final NumberGenerationPolicy generationPolicy;

  public NumberGenerationPolicyDemoDecorator(NumberGenerationPolicy generationPolicy) {
    this.generationPolicy = generationPolicy;
  }

  @Override
  public QDocNumber generate() {
    return generationPolicy.generate().addPrefix("DEMO");
  }
}
