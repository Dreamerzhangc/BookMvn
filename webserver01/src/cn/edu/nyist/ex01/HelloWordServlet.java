package cn.edu.nyist.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWordServlet extends HttpServlet {
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	//首先获取用户名
    	 String name=req.getParameter("uname");
    	 //字节流
    	 PrintWriter out=resp.getWriter();
    	 //不用写响应头，空白行
    	 out.println("hello"+name);
    }
}
