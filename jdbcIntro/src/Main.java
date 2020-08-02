import com.sun.xml.internal.org.jvnet.fastinfoset.sax.FastInfosetReader;

import java.sql.*;
import java.util.ArrayList;

public class Main {

    //    static String userName="root"; //Bağlanmak için gerekli bilgiler.
//    static String password="12345";
//    static String dbUrl="jdbc:mysql://localhost:3306/world"; //Burada world isimli veri tabanına bağlanmak için kullanılan adresdir.Local harici başka makinaya bağlanmak içinse ip yazılmalıdır.
    public static void main(String[] args) throws SQLException {
        //Aşağısı 79.Delete işlemleri ile devam etmektedir.
        Connection connection = null; //Hic bir değeri olmasın istediğimizde null kullanılır.
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null; //
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            // connection= DriverManager.getConnection(dbUrl,userName,password);
            //System.out.println("Bağlantı oluştu");  // Bağlantının olup olmadığını görmek adına bunu yazıyoruz.
            //PrepareStatement cümle hazırla, SQL hazırla anlamındadır.
            //statement=connection.prepareStatement("insert into city (Name,CountryCode,District,Population) value('Düzce','TUR','Düzce',50000)");
            //String sql="update city set population=80000 where id=4083";
            //String sql="update city set name ='Düzce 3',distinct='Düzce' where id=4083";
            //Yukarı satırda ? işareti olan değerler sırasıyla name,Coun.. değişkenlerini dışardan bir kullanıcı tarafından girileceği ve bilinmediğinden bu şekilde kullanılır.

            //String sql="update city set name ='Düzce 3',distinct='Düzce' where id=4083";
            String sql="delete from city where id=?";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,4083);
            int result =statement.executeUpdate(); //Result üzerinden çalıştırdık.
            System.out.println("Kayıt silindi.");

        } catch (SQLException exception) {
            //System.out.println(exception.getMessage());
            helper.showErrorMessage(exception); //helper'a catch bloğundan da ulaşmak için try bloğundan çıkarıp üstündeki satıra aldık.Böylelikle try ve catch bloklarında da ulaşabildik.
        } finally {
            statement.close();
            connection.close(); //Bunun ile işimiz bittiğinde bağlantıyı kapatmasını sağlıyoruz.
        }

    }

    public static void selectDemo() throws SQLException {
        Connection connection = null; //Hic bir değeri olmasın istediğimizde null kullanılır.
        DbHelper helper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        try {
            connection = helper.getConnection();
            // connection= DriverManager.getConnection(dbUrl,userName,password);
            //System.out.println("Bağlantı oluştu");  // Bağlantının olup olmadığını görmek adına bunu yazıyoruz.
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select Code, Name,Continent, Region from country");
            ArrayList<Country> countries = new ArrayList<Country>();
            while (resultSet.next()) {
                //System.out.println(resultSet.getString("Name"));//Bu direk listeyi ekrana yazdırmaktadır.Ama uygulamaların içerisinde genelde resultSet bir nesne listesinin içerisine atılır ki o listeyi istediğimiz gibi kullanabilelim.
                countries.add(new Country(
                        resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region")));
            }
            System.out.println(countries.size());

        } catch (SQLException exception) {
            //System.out.println(exception.getMessage());
            helper.showErrorMessage(exception); //helper'a catch bloğundan da ulaşmak için try bloğundan çıkarıp üstündeki satıra aldık.Böylelikle try ve catch bloklarında da ulaşabildik.
        } finally {
            connection.close(); //Bunun ile işimiz bittiğinde bağlantıyı kapatmasını sağlıyoruz.
        }
        //Yukarısı 76.ResultSet'in Nesnelere Aktarılmasına kadar ki kısımı içermektedir.

    }

        public static void insertData() throws SQLException{
            //Aşağısı 77.Insert işlemleri ile devam etmektedir.
            Connection connection = null; //Hic bir değeri olmasın istediğimizde null kullanılır.
            DbHelper helper = new DbHelper();
            PreparedStatement statement = null; //
            ResultSet resultSet;
            try {
                connection = helper.getConnection();
                // connection= DriverManager.getConnection(dbUrl,userName,password);
                //System.out.println("Bağlantı oluştu");  // Bağlantının olup olmadığını görmek adına bunu yazıyoruz.
                //PrepareStatement cümle hazırla, SQL hazırla anlamındadır.
                //statement=connection.prepareStatement("insert into city (Name,CountryCode,District,Population) value('Düzce','TUR','Düzce',50000)");
                String sql="insert into city (Name,CountryCode,District,Population) value(?,?,?,?)";
                //Yukarı satırda ? işareti olan değerler sırasıyla name,Coun.. değişkenlerini dışardan bir kullanıcı tarafından girileceği ve bilinmediğinden bu şekilde kullanılır.
                statement=connection.prepareStatement(sql);
                statement.setString(1,"Düzce 2");
                statement.setString(2,"TUR");
                statement.setString(3,"Turkey");
                statement.setInt(4,70000);

                int result =statement.executeUpdate(); //Result üzerinden çalıştırdık.
                System.out.println("Kayıt eklendi.");

            } catch (SQLException exception) {
                //System.out.println(exception.getMessage());
                helper.showErrorMessage(exception); //helper'a catch bloğundan da ulaşmak için try bloğundan çıkarıp üstündeki satıra aldık.Böylelikle try ve catch bloklarında da ulaşabildik.
            } finally {
                statement.close();
                connection.close(); //Bunun ile işimiz bittiğinde bağlantıyı kapatmasını sağlıyoruz.
            }
        }

        public void updateData() throws SQLException{
            //Aşağısı 78.Update işlemleri ile devam etmektedir.
            Connection connection = null; //Hic bir değeri olmasın istediğimizde null kullanılır.
            DbHelper helper = new DbHelper();
            PreparedStatement statement = null; //
            ResultSet resultSet;
            try {
                connection = helper.getConnection();
                // connection= DriverManager.getConnection(dbUrl,userName,password);
                //System.out.println("Bağlantı oluştu");  // Bağlantının olup olmadığını görmek adına bunu yazıyoruz.
                //PrepareStatement cümle hazırla, SQL hazırla anlamındadır.
                //statement=connection.prepareStatement("insert into city (Name,CountryCode,District,Population) value('Düzce','TUR','Düzce',50000)");
                //String sql="update city set population=80000 where id=4083";
                //String sql="update city set name ='Düzce 3',distinct='Düzce' where id=4083";
                //Yukarı satırda ? işareti olan değerler sırasıyla name,Coun.. değişkenlerini dışardan bir kullanıcı tarafından girileceği ve bilinmediğinden bu şekilde kullanılır.

                //String sql="update city set name ='Düzce 3',distinct='Düzce' where id=4083";
                String sql="update city set population =100000,district='Turkey' where id=?";
                statement=connection.prepareStatement(sql);
                statement.setInt(1,4083);
                int result =statement.executeUpdate(); //Result üzerinden çalıştırdık.
                System.out.println("Kayıt güncellendi.");

            } catch (SQLException exception) {
                //System.out.println(exception.getMessage());
                helper.showErrorMessage(exception); //helper'a catch bloğundan da ulaşmak için try bloğundan çıkarıp üstündeki satıra aldık.Böylelikle try ve catch bloklarında da ulaşabildik.
            } finally {
                statement.close();
                connection.close(); //Bunun ile işimiz bittiğinde bağlantıyı kapatmasını sağlıyoruz.
            }
        }
}
