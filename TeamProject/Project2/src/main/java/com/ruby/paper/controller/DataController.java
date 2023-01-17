package com.ruby.paper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ruby.paper.domain.DataVO;
import com.ruby.paper.service.DataService;

@RestController
public class DataController {

	@Autowired
	private DataService ds;
	
	//컨트롤러 생성자
	public DataController() {
		System.out.println("DataController() 생성자가 호출됨");
	}
	
	//MySQL DB의 정보를 읽옴
	@GetMapping("/data")
	public List<DataVO> getList(){
		System.out.println("DataController - getList()호출");
		return ds.getList();
	}
	
	//차량번호로 식별하여 차량 정보를 불러옴
	@GetMapping("/data/{car_num}")
	public DataVO getSearch(@PathVariable String car_num) {
		System.out.println("DataController = getSearch()호출");
		return ds.getSearch(car_num);
	}	
}
