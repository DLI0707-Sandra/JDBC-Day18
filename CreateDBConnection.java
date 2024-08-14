import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDBConnection
{

    public static void main(String[] args)
    {
        try(Connection connection = DatabaseConnection.getConnection(); ) {

            System.out.println("Connection successful!");

        } catch (SQLException e) {
            System.out.println("Couldn't connect");
            System.out.println(e);
        }

    }
}
