import java.sql.*;

public class UpdateandDisplay
{
    private static final String URL="jdbc:postgresql://localhost:5432/school_db";
    private static final String USER="postgres";
    private static final String PASSWORD="1234";

    public static void main(String[] args) {
        String update="update students set grade=? where id=?";
        String select="select * from students";
        try(Connection connection= DriverManager.getConnection(URL,USER,PASSWORD);)
        {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement=connection.prepareStatement(update);
            preparedStatement.setString(1,"A");
            preparedStatement.setInt(2,1);
            preparedStatement.executeUpdate();
            connection.commit();

            PreparedStatement preparedStatement1=connection.prepareStatement(select);
            ResultSet set=preparedStatement1.executeQuery();
            while (set.next())
            {
                int id=set.getInt("id");
                String name=set.getString("name");
                String grade=set.getString("grade");
                System.out.println(id+" "+name+" "+grade);
            }
        }catch (SQLException e)
        {
            System.out.println(e);
        }
    }
}
