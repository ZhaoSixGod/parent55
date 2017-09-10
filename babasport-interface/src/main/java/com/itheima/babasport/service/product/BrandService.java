package com.itheima.babasport.service.product;

import java.util.List;

import com.itheima.babasport.pojo.product.Brand;

import cn.itcast.common.page.Pagination;

public interface BrandService {
	
	//查询品牌结果集
	public List<Brand> selectBrandListByQuery(String name,Integer isDisplay);
	
	
	//查询分页对象
	public Pagination selectPaginationByQuery(Integer pageNo,String name,Integer isDisplay);
	
	
}
