package com.itheima.babasport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itheima.babasport.pojo.product.Brand;
import com.itheima.babasport.pojo.product.Color;
import com.itheima.babasport.service.product.BrandService;
import com.itheima.babasport.service.product.ColorService;
import com.itheima.babasport.service.product.ProductService;

import cn.itcast.common.page.Pagination;

/**
 * 商品管理
 * @author Administrator
 *
 */
@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private BrandService brandService;
	
	//商品列表查询
	@RequestMapping(value="/product/list.do")
	public String list(Integer pageNo,String name,Long brandId,Boolean isShow,Model model){
		
		//查品牌结果集
		List<Brand> brands = brandService.selectBrandListByQuery(null, 1);
		model.addAttribute("brands", brands);
		
		
		//通过上面的条件查询分页对象
		Pagination pagination = productService.selectPaginationByQuery(name, brandId, isShow, pageNo);
		model.addAttribute("pagination", pagination);
		model.addAttribute("name", name);
		model.addAttribute("brandId", brandId);
		model.addAttribute("isShow", isShow);
		
		return "product/list";
	}
	
	@Autowired
	private ColorService colorService;
	
	//去添加页面
	@RequestMapping(value="/product/toAdd.do")
	public String toAdd(Model model){
		
		//品牌结果集
		List<Brand> brands = brandService.selectBrandListByQuery(null, 1);
		model.addAttribute("brands", brands);
		
		//颜色结果集
		List<Color> colors = colorService.selectColorList();
		model.addAttribute("colors", colors);
		
		return "product/add";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
