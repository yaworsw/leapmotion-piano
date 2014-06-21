package airguitar;

public enum InstrumentType {

  BEEP  ("beep"),
  PIANO ("piano");

  public static final InstrumentType DEFAULT = InstrumentType.PIANO;

  private String name;

  private InstrumentType(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
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
