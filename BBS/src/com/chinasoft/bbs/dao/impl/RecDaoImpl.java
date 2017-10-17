package com.chinasoft.bbs.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.chinasoft.bbs.dao.IRecDao;
import com.chinasoft.bbs.entity.Recomment;
import com.chinasoft.bbs.util.DBUtil;

public class RecDaoImpl implements IRecDao{

	@Override
	public ArrayList<Recomment> findAllRecommends() {
		// TODO Auto-generated method stub
		DBUtil db=new DBUtil();
		String sql="select * from recomment";
		List<Recomment> list=new ArrayList<Recomment>();
		ResultSet res=db.execQuery(sql, new Object[]{});
		try {
			while(res.next()){
				Recomment rec=new Recomment();
				rec.setRid(res.getInt(1));
				rec.setRecontent(res.getString(2));
				rec.setUid(res.getInt(3));
				rec.setCtime(res.getDate(4));
				rec.setCid(res.getInt(5));
				list.add(rec);
			}
			
			return (ArrayList<Recomment>) list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closeConn();
		}
		return null;
	}
	

	@Override
	public int addReco(String recotent, int uid, int cid) {
		// TODO Auto-generated method stub
		DBUtil db=new DBUtil();
		String sql="insert into recomment values(null,?,?,now(),?)";
		int rs=db.executOther(sql, new Object[]{recotent,uid,cid});
		if(rs>0){
			return rs;
		}
		return 0;
	}

	@Override
	public int deleteReco(int rid) {
		// TODO Auto-generated method stub
		DBUtil db=new DBUtil();
		String sql="delete from recomment where rid=?";
		int rs=db.executOther(sql, new Object[]{rid});
		if(rs>0){
			return rs;
		}
		return 0;
	}

	@Override
	public int updateReco(Recomment com) {
		// TODO Auto-generated method stub
		DBUtil db=new DBUtil();
		String sql="update recommend set recontent=? where rid=?";
		int rs=db.executOther(sql, new Object[]{com.getRecontent(),com.getRid()});
		if(rs>0){
			return rs;
		}
		return 0;
	}

	@Override
	public ArrayList<Recomment> findByParam(String sel,Object obj) {
		// TODO Auto-generated method stub
		DBUtil db=new DBUtil();
		String sql = "select * from recomment where "+sel+"=?";
		ResultSet res=(ResultSet) db.execQuery(sql, new Object[]{obj});
		ArrayList<Recomment> list=new ArrayList<Recomment>();
		try {
			while(res.next()){
				Recomment rec=new Recomment();
				rec.setRid(res.getInt(1));
				rec.setRecontent(res.getString(2));
				rec.setUid(res.getInt(3));
				rec.setCtime(res.getDate(4));
				rec.setCid(res.getInt(5));
				list.add(rec);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closeConn();
		}
		return null;
	}
	
}
