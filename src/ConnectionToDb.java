import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionToDb {

    //JDBC and database properties.
    private static final String DB_DRIVER =
            "com.mysql.jdbc.Driver";
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/w3resources";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "57247";

    public static void main(String[] args) {
        Connection conn = null;

        try {
            //Register the JDBC driver


            //Open the connection
            conn = DriverManager.
                    getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String sql = "INSERT INTO company_mast(COM_NAME) VALUES(?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "msi");
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("a row has been inserted.");
            }
            statement.close();

        } catch (SQLException e) {
            System.out.println("error...!");
            e.printStackTrace();
        }
    }
}


