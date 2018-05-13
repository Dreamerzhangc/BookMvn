package cn.deu.bookmvn1.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cn.deu.bookmvn.biz.BookAddBiz;
import cn.deu.bookmvn.biz.impl.BookAddBizImpl;

/**
 * Servlet implementation class BookAddServlet
 */
@WebServlet("/bookadd")
// 文件上传需要添加
@MultipartConfig
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookAddServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 1.解决上传
		Part part = request.getPart("photo");
		String fileName = part.getHeader("Content-Disposition").split(";")[2].split("=")[1].replace("\"", "");
		// 解决IE下错误问题
		fileName = fileName.lastIndexOf("\\") == -1 ? fileName : fileName.substring(fileName.lastIndexOf("\\") + 1);

		// 存在hibernate.cfg.xml这种⽂件名
		String ext = fileName.substring(fileName.lastIndexOf('.') + 1);
		String newFileName = UUID.randomUUID().toString() + "." + ext;
		part.write(request.getServletContext().getRealPath("upload/" + newFileName));
		//获取参数
		String name=request.getParameter("name");
		String descri=request.getParameter("descri");
		String strPrice=request.getParameter("price");
		double price=Double.parseDouble(strPrice);
		String author=request.getParameter("author");
		String strTid=request.getParameter("tid");
		int tid=Integer.parseInt(strTid);
		String strPubdate=request.getParameter("pubdate");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date pubdate=null;
		try {
			 pubdate=sdf.parse(strPubdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//调用业务层
		BookAddBiz bookAddBiz=new BookAddBizImpl();
		int ret=bookAddBiz.saveBook(name,descri,price,author,newFileName,tid,pubdate);
		//给用户反馈
		System.out.println(ret+"行受影响");
		response.setContentType("text/html;charset=utf-8");
		if (ret>0) {
			response.getWriter().write("添加成功");
		} else {
			request.getRequestDispatcher("bookAdd.jsp").forward(request, response);
		}
	}

}
