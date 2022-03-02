import java.util.List;

public class UI {

    public static void main(String[] args) {



//        String op="/";
//        int nr1=500;
//        int nr2=101;
//
//        String username="condor ionel daniel";
//        double result = AritmeticOperations.doMath(username,op,nr1,nr2);
//        System.out.println(result);


        String qUser="condor1";
        List listOfOperationsForQUser = SaveDBAritmeticOperations.retriveFromDB(qUser);

        // parcurg lista cu un for si o afisez
        System.out.println(listOfOperationsForQUser);

    }
}
