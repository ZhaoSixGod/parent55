package com.itheima.babasport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itheima.babasport.pojo.product.Brand;
import com.itheima.babasport.service.product.BrandService;

/**
 * 品牌管理
 * @author Administrator
 *
 */
@Controller
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	//品牌管理->列表查询
	@RequestMapping(value = "/brand/list.do")
	public String list(Integer pageNo, String name, Integer isDisplay, Model model){
		
		//查询分页对象
		
		//查询结果集
		List<Brand> brands = brandService.selectBrandListByQuery(name, isDisplay);
		model.addAttribute("brands", brands);
		model.addAttribute("name", name);
		model.addAttribute("isDisplay", isDisplay);
		
		
		return "brand/list";
	}
}
