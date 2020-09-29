/**
 * This example shows the correct way to override
 * the equals() method from the Java Object class.
 * 
 * @author Daniel Valle
 */

class Color {
  private int red, green, blue;

  public Color(int red, int green, int blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  @Override
  public boolean equals(Object other) {
    if (other != null && other instanceof Color) {
      Color otherColor = (Color) other;
      return red == otherColor.red && green == otherColor.green && blue == otherColor.blue;
    }
    return false;
  }
}

class OverrideExample {
  public static void main(String[] args) {
    Object c1 = new Color(0, 0, 0);
    Object c2 = new Color(255, 255, 255);
    Object c3 = new Color(0, 0, 0);

    System.out.println(c1.equals(c2));
    System.out.println(c1.equals(c3));
  }
}