package com.itheima.babasport.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.babasport.dao.product.BrandDao;
import com.itheima.babasport.pojo.product.Brand;
import com.itheima.babasport.pojo.product.BrandQuery;

import cn.itcast.common.page.Pagination;

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
	
	//查询分页对象
	public Pagination selectPaginationByQuery(Integer pageNo,String name,Integer isDisplay){
		
		Pagination pagination=new Pagination();
		
		//当前页
		pagination.setPageNo(Pagination.cpn(pageNo));
		//每页数
		pagination.setPageSize(3);
		//总条数
		BrandQuery brandQuery=new BrandQuery();
		
		StringBuilder params=new StringBuilder();
		
		//判断converter转换 本次转去掉前后空格 还是空格,转成null.即空字符串转为null
		if(null!=name){
			brandQuery.setName(name);
			params.append("name=").append(name);
		}
		if(null!=isDisplay){
			brandQuery.setIsDisplay(isDisplay);
			params.append("&isDiaplay=").append(isDisplay);
		}else{
			//默认值
			brandQuery.setIsDisplay(1);
			params.append("&isDiaplay=").append(1);
		}
		//设置当前页
		brandQuery.setPageNo(pagination.getPageNo());
		//设置每页数
		brandQuery.setPageSize(pagination.getPageSize());
	
		//总条数
		pagination.setTotalCount(brandDao.countBrandByQuery(brandQuery));
		
		//结果集
		pagination.setList(brandDao.selectBrandListByQuery(brandQuery));
		
		//分页在页面上展示
		String url="/brand/list.do"; 
		
		//设置分页页码链接
		pagination.pageView(url, params.toString());
		
		return pagination;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
