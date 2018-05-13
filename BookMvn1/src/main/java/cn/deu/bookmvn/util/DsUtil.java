package cn.deu.bookmvn.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DsUtil {
	//����
  private static ComboPooledDataSource cds=new ComboPooledDataSource();
  public static Connection getConn() throws SQLException
  {
	  return cds.getConnection();
  }
  public static void free(ResultSet rs, Statement stmt,Connection conn)
  {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		 if(stmt!=null) {
			   try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}   
		   }
			if(conn!=null) {
				
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
  }
}
