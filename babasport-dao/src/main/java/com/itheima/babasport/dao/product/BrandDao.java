package com.itheima.babasport.dao.product;

import java.util.List;

import com.itheima.babasport.pojo.product.Brand;
import com.itheima.babasport.pojo.product.BrandQuery;

public interface BrandDao {
	
	//查询结果集
	public List<Brand> selectBrandListByQuery(BrandQuery brandQuery);
}
