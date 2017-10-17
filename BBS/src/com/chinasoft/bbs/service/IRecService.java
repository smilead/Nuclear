package com.chinasoft.bbs.service;

import java.util.ArrayList;
import java.util.Date;

import com.chinasoft.bbs.entity.Recomment;

public interface IRecService {
	//查询全部信息
	public ArrayList<Recomment> findAllRecommends();
	//增加
	public boolean addReco(String recotent,int uid,int cid);
	//删除
	public boolean deleteReco(int rid);
	//修改
	public boolean updateReco(Recomment com);
	//根据条件查询
	public ArrayList<Recomment> findByParam(String sel,Object objs);
}
