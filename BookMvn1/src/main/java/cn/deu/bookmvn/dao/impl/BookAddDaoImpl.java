package cn.deu.bookmvn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import cn.deu.bookmvn.dao.BookAddDao;
import cn.deu.bookmvn.util.DsUtil;

public class BookAddDaoImpl implements BookAddDao {

	@Override
	public int save(String name, String descri, double price, String author, String newFileName, int tid,Date pubdate) {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=DsUtil.getConn();
			String sql="insert into t_book(name,descri,price,author,photo,tid,pubdate) values(?,?,?,?,?,?,?)";
		    stmt=conn.prepareStatement(sql);
		    stmt.setString(1, name);
		    stmt.setString(2, descri);
		    stmt.setDouble(3, price);
		    stmt.setString(4, author);
		    stmt.setString(5, newFileName);
		    stmt.setInt(6, tid);
		   // java.sql.Date----> java.util.Date
		   // stmt.setDate(7, pubdate);
		    stmt.setDate(7, new java.sql.Date(pubdate.getTime()));
			int ret=stmt.executeUpdate();

			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		finally {
			System.out.println("_________________________________");
			DsUtil.free(rs, stmt, conn);	
		}
		
		return 0;
	}

}
