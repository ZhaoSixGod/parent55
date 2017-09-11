package com.itheima.babasport.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.babasport.dao.product.ProductDao;
import com.itheima.babasport.pojo.product.ProductQuery;
import com.itheima.babasport.pojo.product.ProductQuery.Criteria;

import cn.itcast.common.page.Pagination;

/**
 * 商品管理
 * 
 * @author Administrator
 *
 */
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	
	// 通过上面的条件查询分页对象
	public Pagination selectPaginationByQuery(String name,Long brandId,Boolean isShow,Integer pageNo){
		
		ProductQuery productQuery=new ProductQuery();
		//当前页
		productQuery.setPageNo(Pagination.cpn(pageNo));
		//每页数
		productQuery.setPageSize(10);
		//工程代码
		Criteria criteria = productQuery.createCriteria();
		//拼接地址
		StringBuilder params=new StringBuilder();
		//判断
		if(null !=name){
			criteria.andNameLike("%"+ name +"%");
			params.append("name=").append(name);
		}
		if(null != brandId){
			criteria.andBrandIdEqualTo(brandId);
			params.append("&brandId=").append(brandId);
		}
		if(null != brandId){
			criteria.andIsShowEqualTo(isShow);
			params.append("&isShow=").append(isShow);
		}else{
			//默认下架
			criteria.andIsShowEqualTo(false);
			params.append("&isShow=").append(false);
		}
		
		Pagination pagination= new Pagination(
					productQuery.getPageNo(),
					productQuery.getPageSize(),
					productDao.countByExample(productQuery)
				);
		//纠正一下当前页
		productQuery.setPageNo(pagination.getPageNo());
		pagination.setList(productDao.selectByExample(productQuery));
		
		//分页在页面上展示
		String url ="/product/list.do";
		pagination.pageView(url, params.toString());
		
		return pagination;
	}
}
