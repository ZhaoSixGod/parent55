package com.itheima.babasport.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.babasport.dao.product.BrandDao;
import com.itheima.babasport.pojo.product.Brand;
import com.itheima.babasport.pojo.product.BrandQuery;

/**
 * 品牌管理
 * @author Administrator
 *
 */
@Service("brandService")
@Transactional
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private BrandDao brandDao;
	
	//查询品牌结果集
	public List<Brand> selectBrandListByQuery(String name,Integer isDisplay){
		
		BrandQuery brandQuery=new BrandQuery();
		//判断converter转换 本次转去掉前后空格 还是空格,转成null.即空字符串转为null
		if(null!=name){
			brandQuery.setName(name);
		}
		if(null!=isDisplay){
			brandQuery.setIsDisplay(isDisplay);
		}else{
			//默认值
			brandQuery.setIsDisplay(1);
		}
		
		
		return brandDao.selectBrandListByQuery(brandQuery);
	}
	
}
