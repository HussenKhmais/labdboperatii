import java.util.List;

public class UI {

    public static void main(String[] args) {



      /*  String op="+";
        int nr1=500;
        int nr2=100;

        String username="hass2";
        double result = AritmeticOperations.doMath(username,op,nr1,nr2);
        System.out.println(result);*/



       /* String qUser="hass2";
        List listOfOperationsForQUser = SaveDBAritmeticOperations.retriveFromDB(qUser);

        // parcurg lista cu un for si o afisez
        System.out.println(listOfOperationsForQUser);*/

        /*  String produs="faina";
        int stoc=100;

        String username="hussen";
        double result = SaveDBProduse.saveInDB(username,produs,stoc);
        System.out.println(result);*/

        String qUser="hass2";
        List listOfProduseForQUser = SaveDBProduse.retriveFromDB(qUser);

        // parcurg lista cu un for si o afisez
        System.out.println(listOfProduseForQUser);

    }
}
