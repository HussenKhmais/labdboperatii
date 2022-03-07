import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SaveDBProduse {

    public static double SaveDB(String username, String produs, int stoc) {



        int value = SaveDBProduse.saveInDB(username, produs, stoc);

        return value;
    }

    private static int getIDOfAUsername(String username) {

        // 1. ma conectez la db
        final String URL = "jdbc:postgresql://idc.cluster-custom-cjcsijnttbb2.eu-central-1.rds.amazonaws.com:5432/Hassuna";
        final String USERNAME = "ftuser";
        final String PASSWORD = "FastTrack&2022";
        int id =-1;
        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 2. fac un query pe o tabela , intai creez obiectul
            Statement st = conn.createStatement();


            // 3. execut acel query
            ResultSet rs = st.executeQuery("SELECT id FROM users where username='"+username+"'");

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

    public static int saveInDB(String username, String produs, int stoc) {
        int fkuser= getIDOfAUsername(username);
        int val=-1;
        try {
            // 1. ma conectez la db
            final String URL = "jdbc:postgresql://idc.cluster-custom-cjcsijnttbb2.eu-central-1.rds.amazonaws.com:5432/Hassuna";
            final String USERNAME = "ftuser";
            final String PASSWORD = "FastTrack&2022";
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 2. creez un prepared ststement si il populez cu date
            PreparedStatement pSt = conn.prepareStatement("INSERT INTO produse (produs,stoc,fkuser) VALUES(?,?,?)");
            pSt.setString(1,produs);
            pSt.setInt(2,stoc);
            pSt.setInt(3,fkuser);


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

        List<ProduseBean> listaDinDB = new ArrayList<>();
        // cod de jdbc

        // 1. ma conectez la db
        final String URL = "jdbc:postgresql://idc.cluster-custom-cjcsijnttbb2.eu-central-1.rds.amazonaws.com:5432/Hassuna";
        final String USERNAME = "ftuser";
        final String PASSWORD = "FastTrack&2022";
        int id =-1;
        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 2. fac un query pe o tabela , intai creez obiectul



            PreparedStatement pSt = conn.prepareStatement("select \n" +
                    "users.username as u, produse.produs as o, produse.stoc\n" +
                    "from\n" +
                    "users, produse\n" +
                    "where \n" +
                    "username=?\n" +
                    "and \n" +
                    "users.id=produse.fkuser");

            pSt.setString(1,username);


            // 3. executie
            ResultSet rs = pSt.executeQuery();




            // atata timp cat am randuri
            while (rs.next()) {

                // randul curent
                ProduseBean ob = new ProduseBean();
                ob.setUsername(rs.getString("u").trim());
                ob.setProdus(rs.getString("o"));
                ob.setStoc(rs.getInt("stoc"));


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
