import java.sql.*;

public class Transactions
{
    private static final String URL = "jdbc:postgresql://localhost:5432/BankDB";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        String update="update accounts set balance=? where account_number=?";
        String query = "select * from accounts";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = conn.prepareStatement(update);
        ) {
            conn.setAutoCommit(false);
            preparedStatement.setFloat(1,3500.0f);
            preparedStatement.setString(2,"1234");
            preparedStatement.addBatch();
            preparedStatement.setFloat(1,2500.0f);
            preparedStatement.setString(2,"3456");
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
            conn.commit();
            PreparedStatement preparedStatement1=conn.prepareStatement(query);
            ResultSet rs=preparedStatement1.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("account_number");
                String name = rs.getString("name");
                float balance = rs.getFloat("balance");
                System.out.println(id + " " + name + " " + balance);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
