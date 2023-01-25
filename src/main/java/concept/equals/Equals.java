package concept.equals;

import java.util.Objects;

class A{
  int i;
  int j;

  public A(int i, int j) {
    this.i = i;
    this.j = j;
  }

  class B {
    int x;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof A a)) return false;
    return i == a.i && j == a.j;
  }

  @Override
  public int hashCode() {
    System.out.println(Objects.hash("dfsdf", "sdfsdf"));
    return Objects.hash(i, j);
  }
}
public class Equals {
  public static void main(String[] args) {
    A a1 = new A(2,3);
    A a2 = new A(2, 3);
    A.B b = a1.new B();
    System.out.println(a1 == a2);
    System.out.println(a1.equals( a2));
  }
}
