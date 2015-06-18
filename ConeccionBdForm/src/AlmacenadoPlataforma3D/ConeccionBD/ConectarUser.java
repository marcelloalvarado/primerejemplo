/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlmacenadoPlataforma3D.ConeccionBD;

import AlmacenadoPlataforma3D.Administrador;
import java.sql.*;
import javax.swing.JOptionPane;
import AlmacenadoPlataforma3D.Login;
import javax.swing.JTextField;

/**
 *
 * @author Petazeta
 */
public class ConectarUser {
    
     public String respuestapass;
     public int cntreñncr=0;
    
    public void acceso (String rut, String clave){
    Connection con=null;
    Statement consulta=null;
    ResultSet tabla=null;
    
    //Login todo= new Login();
        try{
            //Conectar a Base dato
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/Java_3D","root","");
            consulta = con.createStatement();
            
   tabla=consulta.executeQuery("select rut,clave from usuario where rut ='"+rut+"'" );    
            
   if(tabla.next()){               
                       tabla=consulta.executeQuery("select clave from usuario where clave='"+clave+"'");

                       if(tabla.next()){   
                           Administrador menu= new  Administrador();
                           menu.show();
                           menu.setLocationRelativeTo(null);//Aparece ventana al medio
                            }else
                              {JOptionPane.showMessageDialog(null, "contraseña  incorrecta");
                              respuestapass="";
                              cntreñncr=cntreñncr+1;
                              
                              }                     
                  }
            else {   
                JOptionPane.showMessageDialog(null, "usuario no existente en B.D");
                respuestapass="";
            }
          }
        catch(ClassNotFoundException | SQLException e){
                    System.out.println("Error en la coneccion");
                    JOptionPane.showMessageDialog(null,"Coneccion Erronea. "+e);                 
        }       
    }
}
