package com.itheima.babasport.service.product;

import com.itheima.babasport.pojo.product.Product;

import cn.itcast.common.page.Pagination;

public interface ProductService {
	
	//通过上面的条件查询分页对象
	public Pagination selectPaginationByQuery(String name,Long brandId,Boolean isShow,Integer pageNo);
	
	//保存商品表,返回id
	//保存库存表
	public void insertProduct(Product product);
	
}
