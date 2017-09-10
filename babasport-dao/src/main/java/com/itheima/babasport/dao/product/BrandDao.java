package com.itheima.babasport.dao.product;

import java.util.List;

import com.itheima.babasport.pojo.product.Brand;
import com.itheima.babasport.pojo.product.BrandQuery;

public interface BrandDao {
	
	//查询结果集
	//想查所有就查所有,想查分页就查分页
	public List<Brand> selectBrandListByQuery(BrandQuery brandQuery);
	
	//查询总条数
	public Integer countBrandByQuery(BrandQuery brandQuery);
	
}
