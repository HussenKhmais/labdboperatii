public class AritmeticOperations {

    public static double doMath(String username, String op, int nr1, int nr2) {
        double result =0;

      switch(op) {
          case "+":
              result=nr1+nr2;
              break;
          case "-":
              result=nr1-nr2;
              break;
          case "*":
              result=nr1*nr2;
              break;
          case "/":
              result=(double)nr1/nr2;
              break;
      }

      int value = SaveDBAritmeticOperations.saveInDB(username, op, nr1, nr2, result);
      if(value!=-1)
      return result;
      else
          return -1;
    }
}
