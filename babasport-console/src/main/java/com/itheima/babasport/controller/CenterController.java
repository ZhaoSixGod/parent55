package com.itheima.babasport.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itheima.babasport.pojo.TestTb;
import com.itheima.babasport.service.TestTbService;

/**
 * 后台管理中心
 * @author Administrator
 *
 */
@Controller
public class CenterController {
	
	@Autowired
	private TestTbService testTbService;
	
	//入口
	@RequestMapping(value="/test/index.do")
	public String index(){
		TestTb testTb=new TestTb();
		testTb.setId(6);
		testTb.setName("ajkjka");
		testTb.setBirthday(new Date());
		testTbService.insertTestTb(testTb);
		
		return "index";
	}
}
