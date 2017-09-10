package com.itheima.babasport.service.product;

import java.util.List;

import com.itheima.babasport.pojo.product.Brand;

public interface BrandService {
	public List<Brand> selectBrandListByQuery(String name,Integer isDisplay);
}
