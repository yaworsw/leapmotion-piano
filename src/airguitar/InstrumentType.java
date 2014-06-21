package airguitar;

import airguitar.instruments.*;

public enum InstrumentType {

  BEEP  ("beep",  Beep.class),
  PIANO ("piano", Piano.class);

  public static final InstrumentType DEFAULT = InstrumentType.PIANO;

  private String name;
  private Class<? extends Instrument> klass;

  private InstrumentType(String name, Class<? extends Instrument> klass) {
    this.name  = name;
    this.klass = klass;
  }

  public String getName() {
    return this.name;
  }

  public Instrument build() {
    try {
      return klass.newInstance();
    } catch (IllegalAccessException|InstantiationException ex) {
      System.out.println("Failed to instantiate instrument " + this.name);
      System.out.println("Falling back to default instrument");
      return InstrumentType.DEFAULT.build();
    }
  }

  public static InstrumentType get(String name) {
    InstrumentType found = DEFAULT;
    for (InstrumentType type : InstrumentType.values()) {
      if (type.getName() == name) {
        found = type;
        break;
      }
    }
    return found;
  }

}
