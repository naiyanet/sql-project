
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
public class TestSqlOne {

    public static void main(String[] args) throws SQLException {
        Connection connection=null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", null);
            Statement createStatement = connection.createStatement();
            ResultSet rs = createStatement.executeQuery("SELECT * FROM TEST");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String sex = rs.getString("SEX");
                Date date = rs.getDate("BOD");
                System.out.println("id = " + id + " name = " + name + " sex = " + sex + " date = " + date);
            }
        } finally {
            if(connection!=null){
                connection.close();
            }
        }
    }
}
