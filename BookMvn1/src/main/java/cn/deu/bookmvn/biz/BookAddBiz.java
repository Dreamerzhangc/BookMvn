package cn.deu.bookmvn.biz;

import java.util.Date;

public interface BookAddBiz {

	int saveBook(String name, String descri, double price, String author, String newFileName, int tid, Date pubdate);

	

}
