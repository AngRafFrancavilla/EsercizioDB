package Esercizio;

public class mainApp {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/eserciziodb";
        String username = "root"; // Qui inserisci il tuo username
        String password = "2001"; // Qui inserisci la tua password

        String query = "SELECT * FROM studenti";

        // Creazione dell'istanza di DatabaseManager con le credenziali
        databaseConnection dbManager = new databaseConnection(url, username, password);

        // Esecuzione della query
        dbManager.leggiDati(query);
    }
}
