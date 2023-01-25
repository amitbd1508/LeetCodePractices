package practices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Generics {

  public static void main(String[] args) {
    List<Integer> ints = Arrays.asList(1,2,3);
    List<Double> doubles = Arrays.asList(1.0,2.0,3.0);

    System.out.println(sum(ints));
    System.out.println(sum(doubles));
    System.out.println("jhgj"+100+100);
    new Generics().populate(new ArrayList<Human>());
    new Generics().populate(new ArrayList<Student>());
    new Generics().populate(new ArrayList<LocalStudent>());

    //new Generics().populate(new ArrayList<FairfieldStudent>());
    //new Generics().populate(new ArrayList<InternationalStudent>());
  }

  // writting
  // itself or subclass
  //Upperbound wildcat
  private  static Double sum(List<? extends  Number> list) {
    Double sum = 0.0;
    for (Number t : list) {
      sum += t.doubleValue();
    }
    return sum;

  }

  // read
  // itself or super class
  private void populate(List<? super LocalStudent> list) {
    list.add(new FairfieldStudent());
  }

  class Human{}
  class Student extends Human{}
  class LocalStudent extends Student{}
  class FairfieldStudent extends LocalStudent{}

  class InternationalStudent extends Student{}

}
