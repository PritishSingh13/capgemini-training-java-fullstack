import java.sql.*;

public class CreateDB {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                "root",
                "Rsrooms201@"
            );

            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE DATABASE testdb");

            System.out.println("Database created");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
