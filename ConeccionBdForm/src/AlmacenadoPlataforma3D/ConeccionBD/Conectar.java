package AlmacenadoPlataforma3D.ConeccionBD;
import java.sql.*;

public class Conectar {
Connection Conectar;
public Statement sta;
public Connection Conexion(){
    
    try{      
        Class.forName("com.mysql.jdbc.Driver");
        Conectar=DriverManager.getConnection("jdbc:mysql://localhost/java_3d","root","");
        }
    catch(Exception e){
        System.out.println(e.getMessage());
    } 
         return Conectar;   
}
    
}
