package com.itheima.babasport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台管理中心
 * @author Administrator
 *
 */
@Controller
public class CenterController {
	
	//入口
	@RequestMapping(value="/test/index.do")
	public String index(){
		return "index";
	}
}
