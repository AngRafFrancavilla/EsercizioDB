package Esercizio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class databaseConnection {
    private String url;
    private String username;
    private String password;

    // Costruttore per ricevere URL, username e password
    public databaseConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // Metodo per leggere i dati dal database
    public void leggiDati(String query) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Stampare i dati della tabella
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cognome = rs.getString("cognome");

                System.out.println("ID: " + id + ", Nome: " + nome + ", Cognome: " + cognome);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
