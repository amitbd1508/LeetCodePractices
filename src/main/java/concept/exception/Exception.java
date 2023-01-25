package concept.exception;

public class Exception extends Throwable {

  public static void main(String[] args) {
  }
}

class CustomException extends java.lang.Exception {
  public CustomException(String message) {
    super(message);
  }
}


class MyException1 extends Exception { }
class MyException2 extends Exception {}
