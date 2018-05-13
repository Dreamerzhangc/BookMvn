package cn.deu.bookmvn.biz.impl;

import java.util.Date;

import cn.deu.bookmvn.biz.BookAddBiz;
import cn.deu.bookmvn.dao.BookAddDao;
import cn.deu.bookmvn.dao.impl.BookAddDaoImpl;

public class BookAddBizImpl implements BookAddBiz {

	@Override
	public int saveBook(String name, String descri, double price, String author, String newFileName, int tid,Date pubdate) {
		BookAddDao bookAddDao=new BookAddDaoImpl();
		return bookAddDao.save(name,descri,price,author,newFileName,tid,pubdate);
	}

}
