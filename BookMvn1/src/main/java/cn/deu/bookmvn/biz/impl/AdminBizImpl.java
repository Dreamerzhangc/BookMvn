package cn.deu.bookmvn.biz.impl;

import cn.deu.bookmvn.biz.AdminBiz;
import cn.deu.bookmvn.dao.AdminDao;
import cn.deu.bookmvn.dao.impl.AdminDaoImpl;

public class AdminBizImpl implements AdminBiz {

	@Override
	public boolean findAdminByNameAndPwd(String name, String pwd) {
	   AdminDao adminDao=new AdminDaoImpl();
		return adminDao.get(name,pwd);
	}

}
