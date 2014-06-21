package airguitar;

import airguitar.detectors.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum DetectorType {

  PIANO ("piano", Piano.class);

  public static final DetectorType DEFAULT = DetectorType.PIANO;

  private String name;
  private Class<? extends Detector> klass;

  private DetectorType(String name, Class<? extends Detector> klass) {
    this.name  = name;
    this.klass = klass;
  }

  public String getName() {
    return this.name;
  }

  public Detector build() {
    return build(InstrumentType.DEFAULT.build());
  }

  public Detector build(Instrument instrument) {
    try {
      Constructor<? extends Detector> constructor = klass.getConstructor(Instrument.class);
      return constructor.newInstance(instrument);
    } catch (IllegalAccessException|InstantiationException|InvocationTargetException|NoSuchMethodException ex) {
      System.out.println("Failed to instantiate detector " + this.name);
      System.out.println("Falling back to default detector");
      return DetectorType.DEFAULT.build();
    }
  }

  public static DetectorType get(String name) {
    DetectorType found = DEFAULT;
    for (DetectorType type : DetectorType.values()) {
      if (type.getName() == name) {
        found = type;
        break;
      }
    }
    return found;
  }

}
