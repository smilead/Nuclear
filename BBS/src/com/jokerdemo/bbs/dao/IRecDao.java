package com.jokerdemo.bbs.dao;

import java.util.ArrayList;
import java.util.Date;

import com.jokerdemo.bbs.entity.Recomment;

public interface IRecDao {
	//查询全部信息
	public ArrayList<Recomment> findAllRecommends();
	//增加
	public int addReco(String recotent,int uid,int cid);
	//删除
	public int deleteReco(int rid);
	//修改
	public int updateReco(Recomment com);
	//根据条件查询
	public ArrayList<Recomment> findByParam(String sel,Object ob);
}
