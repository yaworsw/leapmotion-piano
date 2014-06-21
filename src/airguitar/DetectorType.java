package airguitar;

public enum DetectorType {

  PIANO ("piano");

  public static final DetectorType DEFAULT = DetectorType.DRUMS;

  private String name;

  private DetectorType(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
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
