package Esercizio;

public class mainApp {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/eserciziodb";
        String username = "root"; 
        String password = "2001";

        String query = "SELECT * FROM studenti";

        databaseConnection dbManager = new databaseConnection(url, username, password);

        dbManager.inserisciDati();
        dbManager.leggiDati(query);
    }
}
