package com.jokerdemo.bbs.service.impl;

import java.util.ArrayList;
import java.util.Date;

import com.jokerdemo.bbs.dao.UserDAO;
import com.jokerdemo.bbs.dao.impl.RecDaoImpl;
import com.jokerdemo.bbs.dao.impl.UserDAOImpl;
import com.jokerdemo.bbs.entity.Recomment;
import com.jokerdemo.bbs.entity.User;
import com.jokerdemo.bbs.service.IRecService;

public class RecServiceImpl implements IRecService{
	UserDAO usrDAO=new UserDAOImpl();
	@Override
	public ArrayList<Recomment> findAllRecommends() {
		// TODO Auto-generated method stub
		 RecDaoImpl rdi=new RecDaoImpl();
		return rdi.findAllRecommends();
	}

	@Override
	public boolean addReco(String rcotent, int uid, int cid) {
		// TODO Auto-generated method stub
		 RecDaoImpl rdi=new RecDaoImpl();
		 if (rdi.addReco(rcotent, uid, cid)>0) {
			 return true;
		}else{
			return false;
		}
		
	}

	@Override
	public boolean deleteReco(int rid) {
		// TODO Auto-generated method stub
		 RecDaoImpl rdi=new RecDaoImpl();
		 if (rdi.deleteReco(rid)>0) {
			 return true;
		}else{
			return false;
		}
		
	}

	@Override
	public boolean updateReco(Recomment com) {
		// TODO Auto-generated method stub
		 RecDaoImpl rdi=new RecDaoImpl();
		 if (rdi.updateReco(com)>0) {
			 return true;
		}else{
			return false;
		}
	}

	@Override
	public ArrayList<Recomment> findByParam(String sel, Object objs) {
		// TODO Auto-generated method stub
		RecDaoImpl rdi=new RecDaoImpl();
		ArrayList<Recomment> recomends= rdi.findByParam(sel, objs);
		User user=null;
		Recomment recommend=null;
		for(int i=0;i<recomends.size();i++) {
			recommend=recomends.get(i);
			user=usrDAO.quicklyFind(recommend.getUid());
			recommend.setPixname(user.getPixname());
			recommend.setLevel(user.getLevel());
			recomends.set(i, recommend);
		}
		return recomends;
	}

}
