import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectQuery
{
    public static void main(String[] args) {

        try(Connection connection = DatabaseConnection.getConnection();)
        {
            String select_query="select * from employees";
            ResultSet resultSet;
            PreparedStatement preparedStatement=connection.prepareStatement(select_query);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                System.out.println(id+" "+name);
            }

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
