package concept.polymorphisiom;

public class OverLoading {
  void x(){

  }
  int x(int x) throws ClassCastException{
    return x;
  }
}


class Child extends OverLoading{
  @Override
  void x() {
    super.x();
    try{
      y();
    }catch (NoClassDefFoundError | RuntimeException e){
      e.printStackTrace();
    } finally {
      x(2);
      throw new ArithmeticException("");
    }
  }

  void y(){
    throw new ArithmeticException("");
  }
  @Override
  int x(int x) throws ClassCastException {
    return super.x(x);
  }
}
