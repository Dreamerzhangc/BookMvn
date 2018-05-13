package cn.deu.bookmvn1.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.deu.bookmvn.biz.AdminBiz;
import cn.deu.bookmvn.biz.impl.AdminBizImpl;
import cn.deu.bookmvn.util.DsUtil;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 *1.获取参数
		 *2.调用业务层
		 *3.根据业务调用价格返回对于视图 
		 * 
		 */
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String vcode=request.getParameter("vcode");
		//在查询数据库
		//在查询数据库之前进行比较
				HttpSession session = request.getSession(); 
				session.setAttribute("validateCode", session.toString()); 
				String serverVcode=(String) session.getAttribute("validateCode");
				//验证码不区分大小�?
				/*if(!serverVcode.equalsIgnoreCase(vcode))
				{
					// 失败
								request.setAttribute("msg", "验证码错误");
								request.setAttribute("name" , name);
								request.getRequestDispatcher("login.jsp").forward(request, response);
								return ;
				}*/
				//业务层
			    AdminBiz adminBiz=new AdminBizImpl();
			    boolean ret=adminBiz.findAdminByNameAndPwd(name,pwd);
				// 3给用户响�?
				if (ret) {
					response.sendRedirect("bookAdd.jsp");
				} else {
					// 失败
					request.setAttribute("msg", "用户名或者密码错误");
					request.setAttribute("name" , name);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}

			}
	}


