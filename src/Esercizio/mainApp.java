package Esercizio;

public class mainApp {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/eserciziodb";
        String username = "root"; 
        String password = "2001";

        //La Query che esegue il programma
        String query = "SELECT * FROM studenti";

        databaseConnection dbManager = new databaseConnection(url, username, password);

        // Esecuzione della query
        dbManager.inserisciDati();
        dbManager.leggiDati(query);
    }
}
