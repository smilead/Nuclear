package com.jokerdemo.service;

import java.util.List;

import com.jokerdemo.crm.domain.Area;

public interface AreaService {
	Area findById(int areaid);
	List<Area> find(int pid);
}
