import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData
{
    public static void main(String[] args)  {

        String insert="INSERT into products(product_id,product_name,price,category_id) values(?,?,?,?)";
        try(Connection connection=DatabaseConnection.getConnection(); PreparedStatement preparedStatement=connection.prepareStatement(insert))
        {
            preparedStatement.setInt(1,6);
            preparedStatement.setString(2,"Eggs");
            preparedStatement.setFloat(3,60.0f);
            preparedStatement.setInt(4,1);
            preparedStatement.executeUpdate();
        }catch (SQLException e)
        {
            System.out.println(e);
        }
    }
}
