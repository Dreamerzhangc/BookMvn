package cn.deu.bookmvn.dao;

import java.util.Date;

public interface BookAddDao {

	int save(String name, String descri, double price, String author, String newFileName, int tid,Date pubdate);

}
