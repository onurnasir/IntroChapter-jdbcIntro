import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    private String userName="root"; //Bağlanmak için gerekli bilgiler.
    private String password="12345";
    private String dbUrl="jdbc:mysql://localhost:3306/world";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl,userName,password);
    }

    public void showErrorMessage(SQLException exception){ //Burada hatayı yönetmek için loglayabiliriz yada görüntüleyebiliriz.
        System.out.println("Error:"+exception.getMessage());
        System.out.println("Error code:"+exception.getErrorCode());//Bu hataları google zaman içinde öğreneceğiz.
    }
}
