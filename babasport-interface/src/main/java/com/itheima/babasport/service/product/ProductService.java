package com.itheima.babasport.service.product;

import cn.itcast.common.page.Pagination;

public interface ProductService {
	
	//通过上面的条件查询分页对象
	public Pagination selectPaginationByQuery(String name,Long brandId,Boolean isShow,Integer pageNo);
	
}
