package com.ruby.paper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruby.paper.domain.DataVO;
import com.ruby.paper.service.DataService;

@RestController
public class DataController {

	@Autowired
	private DataService ds;
	
	public DataController() {
//		ds = new DataService();
		System.out.println("DataController() 생성자가 호출됨");
	}
	
	
	
	@RequestMapping(value = "/data/hello.json")
	public String helloworld(Model model) {
		return "hello world";
	}
	
	
	
	@GetMapping("/data")
	public List<DataVO> getList(){
		System.out.println("DataController - getList()호출");
		return ds.getList();
	}
	
	@GetMapping("/data/{car_num}")
	public DataVO getSearch(@PathVariable String car_num) {
		System.out.println("DataController = getSearch()호출");
		return ds.getSearch(car_num);
	}	
}
