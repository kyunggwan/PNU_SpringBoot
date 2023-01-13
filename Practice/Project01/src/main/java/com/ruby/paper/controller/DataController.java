package com.ruby.paper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ruby.paper.domain.DataVO;
import com.ruby.paper.service.DataService;

@Controller
public class DataController {

	private DataService ds;
	
	@Autowired
	public DataController() {
		ds = new DataService();
		System.out.println("DataController() 생성자가 호출됨");
	}
	
	@GetMapping("/data")
	public List<DataVO> getList(){
		System.out.println("DataController - getList()호출");
		return ds.getList();
	}
	
}
