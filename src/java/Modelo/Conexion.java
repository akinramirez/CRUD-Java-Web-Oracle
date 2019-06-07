package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection con;
    String url="jdbc:oracle:thin:@192.168.0.34:1521:xe";
    String user="xxxxxxxxx";
    String pass="xxxxxxxxx";
    
    public Connection conectar (){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
        }
        return con;
    }
}
