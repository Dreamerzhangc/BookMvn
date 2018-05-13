package cn.deu.bookmvn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.deu.bookmvn.dao.AdminDao;
import cn.deu.bookmvn.util.DsUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public boolean get(String name, String pwd) {
		// 2.到数据库比较
		Connection conn = null;
		/*
		 * 解决SQL注入问题�?? 1.换类，使�?? PreparedStatement
		 */
		// Statement stmt=null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean ret = false;
		try {
			conn = DsUtil.getConn();
			/*
			 * 存在sql注入问题
			 */
			// String sql="select * from t_user where name='"+name+"' and '"+pwd+"'";
			/*
			 * 2.使用占位符代拼接字符 //?就是占位符， 表⽰将来要⽤�??个具体来替代改位�??
			 */
			String sql = "select * from t_admin where name=? and pwd=?";
			System.out.println(sql);
			stmt = conn.prepareStatement(sql);
			/*
			 * 指定参数设置为给�?? Java String 值�?�在将此值发送给数据库时，驱动程序将它转换成�??�?? SQL VARCHAR �??
			 * LONGVARCHAR 值（取决于该参数相对于驱动程序在 VARCHAR 值上的限制的大小）�??
			 */
			// 对特殊符号进行转�??
			stmt.setString(1, name);
			stmt.setString(2, pwd);
			// 修改�??:因为上⾯已经传⼊并⾮占位符赋值了�?? 因⽽表再�??
			// rs=stmt.executeQuery(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				ret = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DsUtil.free(rs, stmt, conn);
		}
		return ret;
	}

}
