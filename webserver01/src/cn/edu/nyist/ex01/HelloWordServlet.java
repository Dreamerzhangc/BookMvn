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
    	//���Ȼ�ȡ�û���
    	 String name=req.getParameter("uname");
    	 //�ֽ���
    	 PrintWriter out=resp.getWriter();
    	 //����д��Ӧͷ���հ���
    	 out.println("hello"+name);
    }
}
