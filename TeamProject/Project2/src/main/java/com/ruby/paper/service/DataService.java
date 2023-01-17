package com.ruby.paper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruby.paper.dao.data.DataDao;
import com.ruby.paper.dao.log.LogDao;
import com.ruby.paper.domain.DataVO;

@Service
public class DataService {

	@Autowired
	private DataDao dao;
	@Autowired
	private LogDao log;
	
	public DataService() {
//	dao = new DataDao();
//	log = new LogDao();
}
	
	public List<DataVO> getList(){
		
		List<DataVO> list = dao.getList();
		if(list!=null) {
			log.addLog("get", dao.getSql(), true);
		} else {
			log.addLog("get", dao.getSql(), false);
		}
		return list;
	}
	
	public DataVO getSearch(String car_num) {
		
		DataVO d = dao.getSearch(car_num);
		if(d!=null) {
			log.addLog("get", dao.getSql(), true);
		} else {
			log.addLog("get", dao.getSql(), false);
		}
		return d;
	}
	
}
