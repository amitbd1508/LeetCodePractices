package concept;

public enum ColorEnum {
  RED, GREEN, BLUE;
  private ColorEnum() {
    System.out.println(this.toString());
  }

  public static void main(String[] args) {
    for (ColorEnum c: ColorEnum.values()) {
      System.out.println(c + "   "+ c.ordinal());
    }
  }

}

class CloneClass implements Cloneable {

}
