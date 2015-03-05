
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author M6500
 */
public class InsertSqlTest {

    public static void main(String[] args) throws SQLException {
        Connection connection=null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", null);
            Statement createStatement = connection.createStatement();
            int rs = createStatement.executeUpdate("INSERT INTO TEST(ID,NAME,SEX,BOD) VALUES(4,'BBB','MEN',CURRENT_DATE())");
            System.out.println("insert result rows"+rs);
        } catch(SQLException e){
            e.printStackTrace();
        }finally {
            if(connection!=null){
                connection.close();
            }
        }
    }
}
