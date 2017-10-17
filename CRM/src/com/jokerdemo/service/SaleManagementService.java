package com.jokerdemo.service;

import java.util.List;

import com.jokerdemo.crm.domain.Chance;
import com.jokerdemo.crm.po.PageModel;

public interface SaleManagementService {
	public PageModel<Chance> searchChance(String searchCustomername,String searchContactsname,String searchDescription,int currentPage, int pageSize);
	public Chance getChance(int id);
	public String addChance(Chance chance);
	public boolean delete(Integer id);
	public boolean assignChanceService(Integer chanceId,Integer userid);
	public boolean updateChanceService(Chance chance);
}
