/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;
/**
 *
 * @author Jose
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

public Connection Conexion;
public String Tabla;

/**
* Método utilizado para recuperar el valor del atributo conexion
* @return conexion contiene el estado de la conexión
*
*/
   /**
* Método utilizado para establecer la conexión con la base de datos
* @return estado regresa el estado de la conexión, true si se estableció la conexión,
* falso en caso contrario
*/
public boolean crearConexion(String Driver,String ServerBD, String Usuario, String Password)
{
   try {
      //Class.forName("com.mysql.jdbc.Driver");
      //  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       Class.forName(Driver);
      //Conexion = DriverManager.getConnection("jdbc:mysql://host:puerto/baseDatos","usuario","contraseña");
      //String CadenaSQLServer = "jdbc:sqlserver://localhost:1433;" +
      //"databaseName=pubs;user=sa; password=adminadmin;";   
      Conexion = DriverManager.getConnection(ServerBD,Usuario,Password);
   } catch (SQLException ex) {
      ex.printStackTrace();
      return false;
   } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
      return false;
   }
   return true;
}
 
/**
*
*Método utilizado para realizar las instrucciones: INSERT, DELETE y UPDATE
*@param sql Cadena que contiene la instrucción SQL a ejecutar
*@return estado regresa el estado de la ejecución, true(éxito) o false(error)
*
*/
public boolean ejecutarSQL(String sql)
{
   try {
      Statement sentencia = Conexion.createStatement();
      sentencia.executeUpdate(sql);
   } catch (SQLException ex) {
      ex.printStackTrace();
   return false;
   }
 
   return true;
}
 
/**
*
*Método utilizado para realizar la instrucción SELECT
*@param sql Cadena que contiene la instrucción SQL a ejecutar
*@return resultado regresa los registros generados por la consulta
*
*/
public ResultSet ejecutarSQLSelect(String sql)
{
   ResultSet resultado;
   try {
      Statement sentencia = Conexion.createStatement();
      resultado = sentencia.executeQuery(sql);
   } catch (SQLException ex) {
      ex.printStackTrace();
      return null;
   }
   return resultado;
}
 

    
}
