import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SaveDBAritmeticOperations {

    //save in db
    //retrieve from db

    private static int getIDOfAUsername(String username) {

        // 1. ma conectez la db
        final String URL = "jdbc:postgresql://idc.cluster-custom-cjcsijnttbb2.eu-central-1.rds.amazonaws.com:5432/ionelcondor";
        final String USERNAME = "ftuser";
        final String PASSWORD = "";
        int id =-1;
        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 2. fac un query pe o tabela , intai creez obiectul
            Statement st = conn.createStatement();


            // 3. execut acel query
            ResultSet rs = st.executeQuery("SELECT id FROM USERS where username='"+username+"'");

            // 4 . optional, fac ce doresc cu datele din acest ResultSet

            while (rs.next()) {
                 id = rs.getInt("id");
                break;
            }

            rs.close();
            st.close();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static int saveInDB(String username, String op, int nr1, int nr2, double result) {
        int fkuser= getIDOfAUsername(username);
        int val=-1;
        try {
            // 1. ma conectez la db
            final String URL = "jdbc:postgresql://idc.cluster-custom-cjcsijnttbb2.eu-central-1.rds.amazonaws.com:5432/ionelcondor";
            final String USERNAME = "ftuser";
            final String PASSWORD = "";
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 2. creez un prepared ststement si il populez cu date
            PreparedStatement pSt = conn.prepareStatement("INSERT INTO operations (operator,operand1,operand2,fkuser,result) VALUES(?,?,?,?,?)");
            pSt.setString(1,op);
            pSt.setInt(2,nr1);
            pSt.setInt(3,nr2);
            pSt.setInt(4,fkuser);
            pSt.setDouble(5,result);


            // 3. executie
             val = pSt.executeUpdate();
            System.out.println(val);

            pSt.close();
            conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
          val=-1;

        }
        return val;
    }

    public static List retriveFromDB(String username) {

        List<OperationsBean> listaDinDB = new ArrayList<>();
        // cod de jdbc

        // 1. ma conectez la db
        final String URL = "jdbc:postgresql://idc.cluster-custom-cjcsijnttbb2.eu-central-1.rds.amazonaws.com:5432/ionelcondor";
        final String USERNAME = "ftuser";
        final String PASSWORD = "";
        int id =-1;
        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 2. fac un query pe o tabela , intai creez obiectul



            PreparedStatement pSt = conn.prepareStatement("select \n" +
                    "users.username as u, operations.operator as o, operations.operand1, operations.operand2, operations.result\n" +
                    "from\n" +
                    "users, operations\n" +
                    "where \n" +
                    "username=?\n" +
                    "and \n" +
                    "users.id=operations.fkuser");

            pSt.setString(1,username);


            // 3. executie
            ResultSet rs = pSt.executeQuery();




            // atata timp cat am randuri
            while (rs.next()) {

                // randul curent
              OperationsBean ob = new OperationsBean();
              ob.setUsername(rs.getString("u").trim());
              ob.setOperator(rs.getString("o"));
              ob.setOperand1(rs.getInt("operand1"));
              ob.setOperand2(rs.getInt("operand2"));
              ob.setResult(rs.getDouble("result"));

                listaDinDB.add(ob);


            }

            rs.close();
            pSt.close();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return listaDinDB;
    }

}
