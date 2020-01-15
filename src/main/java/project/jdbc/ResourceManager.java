/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Incognito
 */
public class ResourceManager {
    
    private static String JDBC_DRIVER="oracle.jdbc.driver.OracleDriver";
    private static String JDBC_URL="jdbc:oracle:thin:@localhost:1521:xe";
    private static String JDBC_USER="";
    private  static String JDBC_PASS="";
    private static int INITIAL_POOL_SIZE;
    private static int IDLE_TIME_POOL;
    private static Driver driver = null;
    private static String JDBC_FILE_NAME = "Jdbc";
    
    public static Properties loadProperties(String file){
        Properties prop = new Properties();
        ResourceBundle bundle = ResourceBundle.getBundle(file);
        Enumeration e = bundle.getKeys();
        String key = null;
        
        while(e.hasMoreElements()){
            key=(String) e.nextElement();
            prop.put(key, bundle.getObject(key));
        }
        
        JDBC_DRIVER = prop.getProperty("driver");
        JDBC_URL = prop.getProperty("url");
        JDBC_USER = prop.getProperty("user");
        JDBC_PASS = prop.getProperty("pass");
        INITIAL_POOL_SIZE = Integer.parseInt(prop.getProperty("initial_pool_size"));
        IDLE_TIME_POOL = Integer.parseInt(prop.getProperty("idle_time"));
        // Regresamos el objeto properties con los valores
        // de la conexion a la BD
        return prop;
    }
    
    public static DataSource getDataSource() {
    
    loadProperties(JDBC_FILE_NAME);
    BasicDataSource ds = new BasicDataSource();
    ds.setDriverClassName(JDBC_DRIVER);
    ds.setUrl(JDBC_URL);
    ds.setUsername(JDBC_USER);
    ds.setPassword(JDBC_PASS);
    // Definimos el tamaño del pool de conexiones
    ds.setInitialSize(INITIAL_POOL_SIZE);// en este caso son 20
    // conexiones abiertas
    ds.setMaxIdle(IDLE_TIME_POOL);// definimos el tiempo de espera
    // antes de cerrar la conexion
    return ds;
  }

  public static synchronized Connection getConnection()
          throws SQLException {
    return getDataSource().getConnection();
  }

  public static void close(Connection conn) {
    try {
      if (conn != null) {
        conn.close();
      }
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }
  }

  public static void close(PreparedStatement stmt) {
    try {
      if (stmt != null) {
        stmt.close();
      }
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }
  }

  public static void close(ResultSet rs) {
    try {
      if (rs != null) {
        rs.close();
      }
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }

  }
    
}
