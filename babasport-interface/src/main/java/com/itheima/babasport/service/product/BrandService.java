package com.itheima.babasport.service.product;

import java.util.List;

import com.itheima.babasport.pojo.product.Brand;

import cn.itcast.common.page.Pagination;

public interface BrandService {
	
	//查询品牌结果集
	public List<Brand> selectBrandListByQuery(String name,Integer isDisplay);
	
	
	//查询分页对象
	public Pagination selectPaginationByQuery(Integer pageNo,String name,Integer isDisplay);
	
	//通过id查询一个品牌对象
	public Brand selectBrandById(Long id);
	
	//修改品牌通过id
	public void uploadBrandById(Brand brand);
	
	//通过一堆id删除数据
	public void deletes(Long[] ids);
	
}
