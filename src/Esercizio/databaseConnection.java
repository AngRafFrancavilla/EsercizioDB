package Esercizio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class databaseConnection {
    private String url;
    private String username;
    private String password;

    public databaseConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void inserisciDati() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Inserisci il cognome: ");
        String cognome = scanner.nextLine();

        String query = "INSERT INTO studenti (nome, cognome) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nome);
            stmt.setString(2, cognome);

            int righeAggiunte = stmt.executeUpdate();
            System.out.println(righeAggiunte + " righe inserite.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    public void leggiDati(String query) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cognome = rs.getString("cognome");

                System.out.println("ID: " + id + ", Nome: " + nome + ", Cognome: " + cognome);
            }

        } catch (SQLException e) {
            System.err.println("Errore SQL: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Errore generale: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
