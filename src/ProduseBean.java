public class ProduseBean {
    private String username;
    private   String produs;
    private int stoc;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProdus() {
        return produs;
    }

    public void setProdus(String produs) {
        this.produs = produs;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }


    @Override
    public String toString() {
        return "ProduseBean{" +
                "username='" + username + '\'' +
                ", produs='" + produs + '\'' +
                ", stoc=" + stoc +

                '}';
    }
}
